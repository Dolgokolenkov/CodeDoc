/*Copyright (c) 2010-2023. LUKOIL-Engineering Limited KogalymNIPINeft Branch Office in Tyumen
Данным программным кодом владеет Филиал ООО "ЛУКОЙЛ-Инжиниринг" "КогалымНИПИнефть" в г.Тюмени*/

package test;
import main.MaskHandler;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;

public class MaskHandlerTest {
    private HashMap<String,String[]> extensions;
    private MaskHandler handler=new MaskHandler();
    public MaskHandlerTest(){
        extensions=new HashMap<String,String[]>();
        extensions.put("html",new String[]{"<!--","-->"});
        extensions.put("xml",new String[]{"<!--","-->"});
        extensions.put("java",new String[]{"/*","*/"});
        extensions.put("js",new String[]{"/*","*/"});
        extensions.put("ts",new String[]{"/*","*/"});
        extensions.put("resource",new String[]{"#","#"});
        extensions.put("properties",new String[]{"#","#"});
        extensions.put("py",new String[]{"'''\n","\n'''"});
    }

    @Test
    public void MaskWithoutAnotherSymbols(){
        Assert.assertEquals(handler.HandleMask("lolqw.py","lol.py",extensions),false);
        Assert.assertEquals(handler.HandleMask("lol.py","lol.java",extensions),false);
        Assert.assertEquals(handler.HandleMask("l.py","lol.java",extensions),false);
        Assert.assertEquals(handler.HandleMask("lasdasd.py","lasdasdasdad.java",extensions),false);
        Assert.assertEquals(handler.HandleMask("lol.py","lol.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("1sss.py","1sss.py",extensions),true);
    }

    @Test
    public void MaskWithRandomExtension(){
        Assert.assertEquals(handler.HandleMask("1sss.*p*","1sss.properties",extensions),true);
        Assert.assertEquals(handler.HandleMask("1sss.*p*","1sss.asdasdasdasdad",extensions),false);
        Assert.assertEquals(handler.HandleMask("1sss.*s","1sss.java",extensions),false);
        Assert.assertEquals(handler.HandleMask("1sss.?s","1sss.java",extensions),false);
        Assert.assertEquals(handler.HandleMask("lol.*","lol.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("1sss.*","1sss.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("1sss.?s","1sss.js",extensions),true);
        Assert.assertEquals(handler.HandleMask("1sss.?s","1sss.ts",extensions),true);
        Assert.assertEquals(handler.HandleMask("1sss.*s","1sss.js",extensions),true);
        Assert.assertEquals(handler.HandleMask("1sss.*s","1sss.ts",extensions),true);
    }

    @Test
    public void MaskWithRandomName(){
        Assert.assertEquals(handler.HandleMask("1asd.sdsd.adsasd.asdas.py","1asd.sdsd.adsasd.asdas.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("?asd.sds?.adsas?.asdas.py","1asd.sdsd.adsasd.asdas.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("?asd.sds?.adsas?.*.py","1asd.sdsd.adsasd.asdas.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("*.py","lol.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("*.*.py","lol.lol.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("*l.py","lol.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("*l.py","ahaha.py",extensions),false);
        Assert.assertEquals(handler.HandleMask("l*.py","lol.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("?*.py","lol.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("????*.py","lol.py",extensions),false);
        Assert.assertEquals(handler.HandleMask("????*.py","loll.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("?a?.py","bab.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("?a?.py","bbb.py",extensions),false);
        Assert.assertEquals(handler.HandleMask("?a.py","bab.py",extensions),false);
    }
    @Test
    public void MaskWithRandomNameAndExtension(){
        Assert.assertEquals(handler.HandleMask("?*.*","lol.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("?*.?","lol.py",extensions),false);
        Assert.assertEquals(handler.HandleMask("?*.??","lol.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("?*.???","lol.py",extensions),false);
        Assert.assertEquals(handler.HandleMask("?*.??*","lol.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("??.??","ll.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("?*.??*","loldsadadasd.java",extensions),true);
        Assert.assertEquals(handler.HandleMask("?*.???","loldsadadasd.js",extensions),false);
    }
    @Test
    public void MaskWithNumbersAndOtherSymbols(){
        Assert.assertEquals(handler.HandleMask("*.py","891212.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("89*.py","891212.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("89*.*","891212.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("hello*hi.*","hello891212hi.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("*.*","hello891212hi1.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("*.*","hello891212hi1.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("8?1.*","891.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("8?1.*","8923231.py",extensions),false);
        Assert.assertEquals(handler.HandleMask("8?1.*","8923231.py",extensions),false);
        Assert.assertEquals(handler.HandleMask("*.*","8-961-212-02-34.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("?-???-???-??-??.*","8-961-212-02-34.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("*-*-*-*-*.*","8-961-212-02-34.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("*_*_*_*_*.*","8_961_212_02_34.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("____*.*","____sdada232312.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("____*.*","___sdada232312.py",extensions),false);
        Assert.assertEquals(handler.HandleMask("*?*?*?*?*?.*","8.961.212.02.34.py",extensions),true);
        Assert.assertEquals(handler.HandleMask("*.*.*.*.*.*","8.961.212.02.34.py",extensions),true);
    }
}
