import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class Advertisements
{
    Map<Integer, String> dictionary = new HashMap<>();
    Random rand = new Random();
    public Advertisements()
    {
        dictionary.put(9, "天上太阳红呀红彤彤诶\n" +
                "心中的太阳是毛泽东诶\n" +
                "他领导我们得解放诶\n" +
                "人民翻身当家做主人\n" +
                "咿呀咿吱呦喂\n" +
                "呀而呀吱呦啊\n" +
                "人民翻身当家做主人\n" +
                "天上太阳红呀红彤彤诶\n" +
                "心中的太阳是毛泽东诶\n" +
                "他领导我们奋勇向前进诶\n" +
                "革命江山一耶一片红诶\n" +
                "咿呀咿吱呦喂\n" +
                "呀而呀吱呦啊\n" +
                "革命江山一片红(诶)");
        dictionary.put(10, "While you are gambling away, why don't you spend some time during your gambling breaks playing the sponsor of Ferguson's Casino: RAID: Shadow Legends™!! RAID: Shadow Legends™\uFE0F is getting big real fast, so you should definitely get in early. Starting now will give you a huge head start. There's also an upcoming Special Launch Tournament with crazy prizes! And not to mention, this game is absolutely free!\n" +
                "So go ahead and check out the the QR code on our board to find out more about RAID: Shadow Legends™\uFE0F. There, you will find a link to the store page and a special code to unlock all sorts of goodies. Using the special code, you can get 50,000 Silver immediately, and a FREE Epic Level Champion as part of the new players program, courtesy of course of the RAID: Shadow Legends™\uFE0F devs.\n" +
                "Let me give a HUGE thank you to RAID: Shadow Legends for sponsoring Ferguson's Casino. :)");
        dictionary.put(20, "Ferguson's casino is sponsored by ExpressVPN! In today's day and age, we're spending lots of time online and there will be all sorts of fishy sites out there trying to steal your data and personal information, which is why you should be using a VPN, and there's no better VPN to use than ExpressVPN, as they've been rated the #1 most trusted VPN for over a decade now.\n" +
                "\n" +
                "My favorite use for ExpressVPN is for streaming services like Netflix and Hulu that have regional restrictions on what shows you can want. Since i'm from the United States, I won't be able to access popular shows like Rick and Morty and Friends, but by switching my location through ExpressVPN to the UK, I'll be able to access them whenever I want!\n" +
                "\n" +
                "If you're interested in taking back your internet privacy today and staying secure when surfing the web, go to expressvpn.com/ferguson or use code \"ferguson\" at checkout to get 33% off of a three year plan! And once again, thanks so much to ExpressVPN for sponsoring Ferguson's Casino :).");
        dictionary.put(30, "Hot foodstuffs in your closest Chipotle");
        dictionary.put(40, "Honey is a free browser add-on available on Google, Oprah, Firefox, Safari, if it's a browser it has Honey. All you have to do is when you're checking out on one of these major sites, just click that little orange button, and it will scan the entire internet and find discount codes for you. \nAs you see right here, I'm on Hanes, y'know, ordering some shirts because who doesn't like ordering shirts; We saved 11 dollars! \nDude our total is 55 dollars, and after Honey, it's 44 dollars. Boom. I clicked once and I saved 11 dollars. \nThere's literally no reason not to install Honey. It takes two clicks, 10 million people use it, 100,000 five star reviews, unless you hate money, you should install Honey.");
        dictionary.put(50, "Advertisement endorsed by Burger King:\n" +
                "Whopper, Whopper, Whopper, Whopper\n" +
                "Junior, Double, Triple Whopper\n" +
                "Flame-grilled taste with perfect toppers\n" +
                "I rule this day\n" +
                "Lettuce, mayo, pickle, ketchup\n" +
                "It's okay if I don't want that\n" +
                "Impossible or bacon Whopper\n" +
                "Any Whopper my way\n" +
                "You rule, you're seizin' the day\n" +
                "At BK, have it your way\n" +
                "(You rule)");
        dictionary.put(60, "99% OF GAMBLERS QUIT RIGHT BEFORE THEY HIT IT BIG! WILL YOU BE A QUITTER OR A WINNER?");
        dictionary.put(70, "If you write ANYTHING on your computer, YOU NEED TO GET GRAMMARLY. I write pretty much ALL DAY every day and GRAMMARLY makes my writing better.\nAs a casino worker I like that it's FREE It actually is... correcting everything as I'm writing it. Grammar errors spelling errors... IT EVEN helps me find the right words to use!! SO I can say what I want to say!! \nIt catches all those embarrassing little mistakes BEFORE I HIT SEND!!! I downloaded GRAMMARLY around my freshman year of high school because I was just... Ｈ Ｏ Ｒ Ｒ Ｉ Ｂ Ｌ Ｅ... at typing! \nGrammarly is like my secret weapon for writing papers. It's just the PERFECT tool for your resume, you know you don't want ANY errors when it's your first impression. \nI use GRAMMARLY for important emails, social media posts (which there are a L O T of.) I've used EVERY TOOL OUT THERE!! And Grammarly is by far the ＢＥＳＴ for improving your writing. \nGRAMMARLY is making me a better writer. AND it's free... I would recommend GRAMMARLY if you're a student, my family, my peers, my colleagues, \nIt's like having YOUR OWN personal proof-reader for free.\n");
        dictionary.put(80, "Before you continue gambling, I’d like to thank the sponsor of Ferguson's Casino, “Raycons.” \nI actually have a pair of Raycons and I love them. I usually use them when I’m at the gym or I’m at home playing Minecraft. \nThe sound quality is just as amazing as all the other top name brands and they’re half the price. \nThe ones I’m using are the everyday E25’s. They’re the best ones yet. 6 hours of playtime, seamless Bluetooth pairing, more bass, available in multiple colors, and their compact design helps get rid of background noise. \nI also like the fact that you can click either earbud with your finger to pause your music. Makes it super convenient if you need to stop for any reason. \nGo to buyracon.com/ferguson for 15% off your order. The link is in the QR code on our board.");
        dictionary.put(90, "Man I love air conditioning, and so does Dyson! Get your next air conditioner for 1% off at dyson.com/ferguson!");
        dictionary.put(100, "Want a break from the ads? Try Ferguson's Premium");
    }
    public void adsPrint()
    {
        Integer adsNum = rand.nextInt(100)+1;
        if (dictionary.get(adsNum) != null)
        {
            System.out.println(dictionary.get(adsNum));
        }
    }
}

