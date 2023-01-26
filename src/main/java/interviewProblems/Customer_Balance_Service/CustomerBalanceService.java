package interviewProblems.Customer_Balance_Service;

// ---------------------------------- SOLVED ----------------------------------
// ---------------------- BLOCKCHAIN.COM / December 2022 ----------------------
// Solved as part of a live coding interview @ blockchain.com

//package com.blockchain;

/*
The idea of this coding challenge, is to implement CustomerBalanceService and it must be able to:
- subscribe to upstream balance change notifications from the LedgerService
- keep an accumulated running balance for each customer
- accept subsription from multiple instances of the Customer sercice
- send downstream balance update notifications to subscribed customers.
Steps:
1. Subscribe to balance changes for all customers by providing a LedgerUpdateCallback
   to the LedgerService instance received on the constructor.
2. Update internal data-structure to hold balances for each customer when the
   LedgerUpdateCallback::onBalanceUpdate method is called.
3. If the customer has a registered callback provided via the CustomerBalanceService::subscribe
   method, call the CustomerBalanceUpdateCallback::onBalanceUpdate method with an instance of
   CustomerBalanceUpdate.
Instructions:
- Assume that the LedgerService and Customer interfaces will be implemented by someone else;
- these services communicates via callbacks for simplicity.
- Your implementaion Has to be thread-safe, memory efficient, GC friendly and cpu friendly.
- Use the language you prefer, you can read documentation
- Starting balance of a user is 0
- share your screen while coding, and share your code at the end.
- If you want to change the API contracts discuss it with your interviewer
- Send your code to the interviewer at the end of the interview.
+-----------+                                    +-------------------------+                            +---------------+
| Customer  |                                    | CustomerBalanceService  |                            | LedgerService |
+-----------+                                    +-------------------------+                            +---------------+
      |                                                       | -------------------------------\                    |
      |                                                       |-| ::new(LedgerService)         |                    |
      |                                                       | |------------------------------|                    |
      |                                                       |                                                     |
      |                                                       | subscribe(LedgerUpdateCallback)                     |
      |                                                       |---------------------------------------------------->|
      |                                                       |                                                     |
      | subscribe(CustomerBalanceUpdateCallback)              |                                                     |
      |------------------------------------------------------>|                                                     |
      |                                                       |                                                     |
      |                                                       |                                                     |
      |                                                       |                                                     |
      |                                                       |                                        -----------\ |
      |                                                       |                                        | customer |-|
      |                                                       |                                        | buy/sell | |
      |                                                       |                                        | crypto   | |
      |                                                       |                                        |----------| |
      |                                                       |                                                     |
      |                                                       |                        LedgerServiceUpdateCallback  |
      |                                                       |             ::onBalanceUpdate(LedgerServiceUpdate)  |
      |                                                       |<----------------------------------------------------|
      |                                                       | ------------------\                                 |
      |                                                       |-| update internal |                                 |
      |                                                       | | balances data   |                                 |
      |                                                       | | structure       |                                 |
      |                                                       | |-----------------|                                 |
      |                                                       |                                                     |
      |                         CustomerBalanceUpdateCallback |                                                     |
      |              ::onBalanceUpdate(CustomerBalanceUpdate) |                                                     |
      |<------------------------------------------------------|                                                     |
      |                                                       |                                                     |
*/

import java.util.HashMap;
import java.util.Map;

enum Token {
    USD, EUR, BTC, ETH;
}

/**
 * Message/Event received from the upstream LedgerService,
 * for any change in the balance of any token for any customer
 * Balance Increases if getChange() > 0
 * Balance Decreases if getChange() < 0
 */
interface LedgerServiceUpdate {
    long getCustomer();
    Token getToken();
    double getChange();
}

/**
 * A callback provided to the upstream LedgerService, to be called
 * whenever there is a change in the balance of a customer for any token
 */
interface LedgerServiceUpdateCallback {
    void onBalanceUpdate(LedgerServiceUpdate update);
}

/**
 * Service to subscribe for updates in the balances of all customers
 * (provided)
 */
interface LedgerService {
    void subscribe(LedgerServiceUpdateCallback callback);
}

/**
 * A callback provided to the CustomerBalanceService, to be called
 * whenever there is a change in the balance of a token for the subscribed customer
 */
interface CustomerBalanceUpdateCallback {
    void onBalanceUpdate(CustomerBalanceUpdate update);
}

/**
 * Message/Event sent to the downstream customer balance subscription, whenever
 * the balance for a token for that customer changes
 */
class CustomerBalanceUpdate {

    private final Token token;
    private double balance;
    private double change;

    public CustomerBalanceUpdate(Token token, double balance, double change) {
        this.token = token;
        this.balance = balance;
        this.change = change;
    }

    public Token getToken() {
        return token;
    }

    public double getBalance() {
        return balance;
    }

    public double getChange() {
        return change;
    }
}

/**
 * A Service used by customers to get notifications of changes
 * to their own specific balances, for each {@link Token}
 * (implement)
 */

class CustomerBalanceService {

    private LedgerService balanceService;
    private Map<Long, CustomerBalanceUpdateCallback> subscribedCustomers;
    private Map<Long, Map<Token, Double>> customerBalances;

    public CustomerBalanceService(LedgerService balanceService) {
        // Subscription to the Ledger Service
        this.balanceService = balanceService;
        this.balanceService.subscribe(new LedgerCallback());

        // Internal state variables
        this.subscribedCustomers = new HashMap<>();
        this.customerBalances = new HashMap<>();
    }

    public void subscribe(long customer, CustomerBalanceUpdateCallback callback) {
        // Synchronized block assures thread safety using the map
        synchronized (this.subscribedCustomers) {
            // Store only the latest subscription to avoid spam and memory consumption
            this.subscribedCustomers.put(customer, callback);
        }
    }

    private class LedgerCallback implements LedgerServiceUpdateCallback {
        public void onBalanceUpdate(LedgerServiceUpdate update) {
            synchronized (subscribedCustomers) {
                // Check if the user is subscribed
                if (subscribedCustomers.containsKey(update.getCustomer())) {
                    // Initialize internal balances when the user first gets an update
                    // Avoid initializing maps that would be unused
                    if (!customerBalances.containsKey(update.getCustomer())) customerBalances.put(update.getCustomer(), new HashMap<>());

                    // Get the existing balance for the specific token and update it
                    Map<Token, Double> balances = customerBalances.get(update.getCustomer());
                    double newBalance = balances.getOrDefault(update.getToken(), (double)0.0);
                    newBalance += update.getChange();

                    // Update the internal balance
                    balances.put(update.getToken(), newBalance);

                    // Notify the customer
                    subscribedCustomers.get(update.getCustomer())
                            .onBalanceUpdate(new CustomerBalanceUpdate(update.getToken(), newBalance, update.getChange()));
                }
            }
        }
    }
}