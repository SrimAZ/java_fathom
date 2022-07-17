package com.ogrodnek.lingua.en;

// import org.junit.Assert;
import org.junit.Test;

import com.ogrodnek.lingua.en.Fathom.Stats;


public class FathomTest {
  @Test
  public void testSimple() {
    
    Stats s = Fathom.analyze("Power purchased for 2005 increased $41.4 million compared to 2004 primarily due to an increase in the price of power purchases (increased costs $35.4 million) and partially due to an increase in the volume of power purchases (increased costs $6.0 million). The increase in the price of power represents overall increases in the wholesale energy markets. The increase in the volume of power purchased is consistent with the increase in retail and wholesale sales, partially offset by an increase in thermal generation. </FONT></P> <P STYLE=\"margin-top:12px;margin-bottom:0px\"><FONT FACE=\"Times New Roman\" SIZE=\"2\">Net amortization of deferred power costs was $24.2 million for 2005 compared to $23.0 million for 2004. During 2005, Avista Utilities recovered (collected as revenue) $26.5 million of previously deferred power costs in Washington and $5.7 million in Idaho. There was a decrease in the recovery of previously deferred power costs in Idaho as compared to 2004, which was primarily due to the reduction of the PCA rate surcharge. During 2005, Avista Utilities deferred $4.1 million and $3.9 million of power costs in Washington and Idaho, respectively. There was a decrease in the deferral of power costs due to lower actual electric resource costs as compared to the amount included in base rates in 2005 as compared to 2004. </FONT></P> <P STYLE=\"margin-top:12px;margin-bottom:0px\"><FONT FACE=\"Times New Roman\" SIZE=\"2\">Fuel for generation for 2005 increased $54.6 million compared to 2004 due to an increase in fuel prices and greater use of thermal generation, which increased 52 percent for 2005 as compared to 2004, primarily due to the addition of the remaining interest in Coyote Springs");
    
    // Assert.assertEquals(2, s.getNumSentences());
    // Assert.assertEquals(1, s.getNumComplexWords());
    // Assert.assertEquals(8, s.getNumWords());
    
    System.out.println(s);
    float NumBySentences = (float)s.getNumWords()/s.getNumSentences();
    float ComByWords = (float)s.getNumComplexWords()/s.getNumWords();
    float gFogIndex = (float)(0.4 * (NumBySentences + (100 * ComByWords)));
    System.out.println(gFogIndex);
  }

}
