package interviewProblems.Advent_Of_Code_2022.Day_8.Part_1;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- NONE / December 2022 ---------------------------

/**
 * Original problem: https://adventofcode.com/2022/day/8
 * The expedition comes across a peculiar patch of tall trees all planted carefully in a grid. The Elves explain that a previous expedition planted these trees as a reforestation effort. Now, they're curious if this would be a good location for a tree house.
 * <p>
 * First, determine whether there is enough tree cover here to keep a tree house hidden. To do this, you need to count the number of trees that are visible from outside the grid when looking directly along a row or column.
 * <p>
 * The Elves have already launched a quadcopter to generate a map with the height of each tree (your puzzle input). For example:
 * <p>
 * 30373
 * 25512
 * 65332
 * 33549
 * 35390
 * Each tree is represented as a single digit whose value is its height, where 0 is the shortest and 9 is the tallest.
 * <p>
 * A tree is visible if all of the other trees between it and an edge of the grid are shorter than it. Only consider trees in the same row or column; that is, only look up, down, left, or right from any given tree.
 * <p>
 * All of the trees around the edge of the grid are visible - since they are already on the edge, there are no trees to block the view. In this example, that only leaves the interior nine trees to consider:
 * <p>
 * The top-left 5 is visible from the left and top. (It isn't visible from the right or bottom since other trees of height 5 are in the way.)
 * The top-middle 5 is visible from the top and right.
 * The top-right 1 is not visible from any direction; for it to be visible, there would need to only be trees of height 0 between it and an edge.
 * The left-middle 5 is visible, but only from the right.
 * The center 3 is not visible from any direction; for it to be visible, there would need to be only trees of at most height 2 between it and an edge.
 * The right-middle 3 is visible from the right.
 * In the bottom row, the middle 5 is visible, but the 3 and 4 are not.
 * With 16 trees visible on the edge and another 5 visible in the interior, a total of 21 trees are visible in this arrangement.
 * <p>
 * Consider your map; how many trees are visible from outside the grid?
 */
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "30373\n" + "25512\n" + "65332\n" + "33549\n" + "35390";
        System.out.println(sol.calculateHidden(getMat(input)));
        input = "201111211202111301212201403141040230323033312212134523125000140404300230341330300221220012110101011\n" + "011220103113221111202122124010033421404432343233535151335133353340034134034332440001110102010010220\n" + "122121120300202230411332402004044235424325455343231124521355323541403402031010313440121321321322221\n" + "200021211323122312440342411331012332252341254144425451345233324423152201041200212200331121111210011\n" + "022213121203213301221100041021415245132424534145512125411151335224315551123141404223410032032000022\n" + "101131310332214402243114310442325141344331525541232153453225442351235123130234413214313330121121101\n" + "101102011001014411302320032155533351421345311554341111544153414344211242545240114004311012303003230\n" + "101023122212322231421422241433315213542415532226334465642351151321144451152132311230002433230001110\n" + "101102012000130221414322332331245251153242654525425363234533655232423135443124134230202313201000123\n" + "113023100223214000232555442143243135556634652423636245645335623323351235221252344243002420033131123\n" + "021023012400222133115232154155255455226363244263663662564362455342612241224452135301204334403311211\n" + "011011120014313211333124154235235522553465256455435352362343343356452125515224121432404101240133203\n" + "011310103034221123212123555245622666563625344356454344325522453265262433154414231333142413311331323\n" + "303301320412010454251154421242542562366466364652264364325544554624545256254413534434331434344310311\n" + "211332131030004243315521542363644424356453643345544752562524552255353324654134525543231434112230100\n" + "002102403432244535421254566353326346446265345654366646566543552562536326635315453214125414141214102\n" + "331140031313041444123423526426422252527375577546753455777737547626364645566461554234123523430311313\n" + "330401323101512253253516526653653542734767336644345445665364743533364355534236521342413154132413122\n" + "330411204212311445244535522655343573747374364345564574375763553465534526662642244443311121403103124\n" + "023332003431144254543626226245566455744465356337347475347374637637653442626233624414255134423423042\n" + "244210400021232153266652252325756653575474576355747475663555354556777566436342344532415443212134234\n" + "243022342335541213565253544236755753776564447733743446775775654547533666422423326624134345443023202\n" + "400214112533143341263455565263566576767643378645664845674353474533736575624522664521123334133420203\n" + "314412035353435253634446462463763443376476847467648547566465453356757464475343435464134531133123324\n" + "210413325433315134452365563547564744658868746684566644877466576346553654766362254362221413424430422\n" + "440400434542543525543663633667763537556667668747746756785587458767563547637623326226661151144334010\n" + "203031334152125642466635547657766584664687848767577545486757587488654373354446324524564152231113112\n" + "241001452244343336664255646743677756848545865758665674685886656454447657464556245442364333553250131\n" + "014023224515325454455574567445744885857785756585855854887668646555746475564455722536445351532451133\n" + "240034522142434662453346666663547675448567854897757695674874464454475574464737776424553231541143102\n" + "202432344512662423437374345345446848546655697769865799957684557848684543374647545532223321334341333\n" + "123325111441445225523673536445447568774877677796777678697975965546774547536673437544656344512135444\n" + "310254211535525232233446556788846647746897588857688579889788855477655648566666635426236522424112342\n" + "034313254213653456477557533774786647669769587699976668986696667747555648883667447465462526444143342\n" + "143141533334542466354344755484874754698685556789559989587957999587645467546553365742323424612353420\n" + "023355513126235334753777564744657489776767789956675687857787669856547584455737646446352333233414322\n" + "223531421366552557666573477756875578695968796778976887859959556598778688876655735777332545512434212\n" + "324553233365452565557437476777687565788999986896686778796755558896856684686773556344634525262453452\n" + "213242455253625376773454787557859959899988899999978889797885876979769647857487767764545335245255213\n" + "153212131552226337374543645684765767796896876966989866686867979876788867784675754744525622655431425\n" + "043231154325334367553646774578457959887979898666866967789799775569887978674668454463732263426513135\n" + "335542344226645477333775676444769565755967887779666696689698896656597875884556557743462633443124152\n" + "335323556552426765767775874764689686976988996666779796996969887796587577847457535454643262525413534\n" + "031342356243536356663654658854697858887697788666879779897996867856867654685767655656766443625531132\n" + "335345116666525747477647458845785958767699688899778878776776988777668657478884857465753336533142152\n" + "431315146645532647447566887678656986686996889897797878877768979656986556466744563333546332255135135\n" + "345455244545432335674458658587555587989897879999798888988976986779787768754855836367363664566413353\n" + "512151454564534653477764765466595799679979878789789879998767887865797755765458674344355656253343334\n" + "223351266325633575663774564489796879687898688978997788798999779796767956656764647364636656442223522\n" + "453333263535357446366584455459557799968998879988898977978787696768578657875454473547567326532334111\n" + "522431356454444356554374544846975859978878977879979897898976787967789578746656874774547443245541214\n" + "524451243233255555453685476745875568898798878799987879899778979895889689545784464464664644546653534\n" + "351343243662255667567757864679695778779676778997998897779866887675677768667848643753754363345434313\n" + "422125253344236737334386654576687898997799677887987777887686867895579866465457665345774366464351334\n" + "421312154235324535653777678786976887577869769887898799897698686878966689468464555357752255363554413\n" + "134231353356532647544747466746997955968966989988799777786898667996595997676454734577542423644111423\n" + "254152156456563434474788846574786769698798686897989989968667786695865858667776755455566654264132134\n" + "325554124554345334573567875686789766777879789968978788797868997657598864755765764646452636426312235\n" + "054421142246245654657458647846877765696688798786967788769769989568865887586878654537663362654432212\n" + "313445116364256444775744655676857696698998799776867668888686999587568854476648764345346236246232241\n" + "143114554233652245375455887678668996669686996999796887877777686757966588885786556444465552442533324\n" + "251331534446564265464364486744686986675876988887767766688896987878765756544754746565355566534235144\n" + "043312335432626344536643484678579666899596766779666899678676979556965588747766665377565544465543531\n" + "242445211324566636637644588748444588767957766968968978786788586989657745475556775355542555362121442\n" + "243253334442556446446767754567476657566957796656988796979699968699856846446535677455225423345132114\n" + "431231245536522344674653635685865849787997986689665576586668667768645854645567336572252526524445114\n" + "431352413545636624334373564776844687557987796967657766857786797968874766656443453336264564435235253\n" + "320554134146445446354475753477858558775599755977987865757897668588588666485457344365453335234122310\n" + "333244132156433233245637373688448784459857795676588655998585696485786865554473364636554335355224153\n" + "113345451542245623453737457745456844757575897756758966757557585554868888643374344325656234154414322\n" + "444045515145356432335647545655765786587886758778866688968984877775888576477747477332355221552413204\n" + "111132223523345626324747765577376687656748476986565687576768448558884573773436752362454612221523223\n" + "022004333435234546566255554533348546676766478456868467444674448586545655467537436553554433123421120\n" + "333231125332152663266433667535537778555667876464765456758647764446877656465367323254523253352510413\n" + "122420553331452433333353464676537646864677748867574756565588454444657764464332235454635225432522004\n" + "120442052444321222226423365375645435468656658447866466574856466886677654746522644365264535531343440\n" + "421404315233111265423463525657764565658784687768567656464684688763534555373553346542234345145442244\n" + "331231242152133344456244633655545655745345664668565885467456447677744435752654334432232553354400240\n" + "203040023155425242246555225235473556554656638646764676455766756555576576336522336454124215215404311\n" + "020211430251454452662234222644467675755747776474545447746753537773655567623542436262213453434423110\n" + "121222320253353333233652252225333343646436546477634345533376676557363636362664225322253234514301234\n" + "131331122021145511555626563643364773337345554777664437674344775376757362452454652245212143131222333\n" + "333033033132243135213222343542265476344656453763774355443644566737723253264252451243142121312244244\n" + "002204430244435144434515354453332632665637375363445456667774576662453443646454532431524140202312242\n" + "121314024424022223215424644426642356264655357667436346735353466356245254264535315425323522230030301\n" + "021012030013043135124451434556465446663353754754774574457663344656553456246613524313152023413220330\n" + "323211122442404125421353336334324324563564625653556556652432462453235325362525324531133444231304313\n" + "221212242244240214314234323556334553353656452662622464552256465443444565421332134313540102100220131\n" + "003121311143322334241133533143446663652225433332652353542523664466644655215235421122322101243201202\n" + "302132313044423014553344334444135543546462343625633335635554425246463354552555544450021401441212013\n" + "211320002042341321404351332421424422345645623225243263532425463422453534224512413420003024103010003\n" + "121321233203044310220544225434555523322652465244626362265436622244421244514121221412000233313302001\n" + "033330113222134212123014455534453323452146635634333522662322621122442141151325121244124021100331010\n" + "003211203200004004334013134312421412135211541122652523655533352215155345414442033214440410020130131\n" + "000310132331000133341101412343222324131145425545545422415232421245514432554132410203120223330322031\n" + "010222121001201110014203011212115523421525414334222144411533424243442552424243301203331330320011211\n" + "202210333132013102411304342331452231412212555243242135532222244343234442033031110220213320300213112\n" + "021110333231201113044040042034211335553321154444412432243122252145522223420412102042311030021122200\n" + "212222233011232310420321434331332422434543133323345512355241515513414041433311311240302022331021120";
        System.out.println(sol.calculateHidden(getMat(input)));
    }

    public static int[][] getMat(String input) {
        String[] rows = input.split("\n");
        int[][] mat = new int[rows.length][rows[0].length()];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length(); j++) {
                mat[i][j] = rows[i].charAt(j) - '0';
            }
        }
        return mat;
    }
}