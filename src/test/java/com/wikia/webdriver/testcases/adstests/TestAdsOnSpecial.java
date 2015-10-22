package com.wikia.webdriver.testcases.adstests;

import com.wikia.webdriver.common.dataprovider.ads.AdsDataProvider;
import com.wikia.webdriver.common.templates.TemplateNoFirstLoad;
import com.wikia.webdriver.pageobjectsfactory.pageobject.adsbase.AdsBaseObject;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;


/**
 * @link https://www.google.com/dfp/5441#delivery/LineItemDetail/lineItemId=126608052
 * @ownership AdEngineering Wikia
 */
@Test(
    groups = {"Ads_Special_Pages", "Ads"}
)
public class TestAdsOnSpecial extends TemplateNoFirstLoad {

  @Test(
      groups = {"TestAdsOnSpecialPages_GeoEdgeFree"},
      dataProviderClass = AdsDataProvider.class,
      dataProvider = "specialPages"
  )
  public void TestAdsOnSpecialPages_GeoEdgeFree(String wikiName, String article, String lineItemId,
                                                String adUnit, String leaderboardSlot,
                                                String prefooterSlot,
                                                Dimension resolution) throws Exception {
    String testedPage = urlBuilder.getUrlForPath(wikiName, article);
    AdsBaseObject ads = new AdsBaseObject(driver, testedPage, resolution);

    ads.verifyGptIframe(adUnit, leaderboardSlot, "gpt");
    ads.verifyGptAdInSlot(leaderboardSlot, lineItemId, "");
    ads.verifyGptIframe(adUnit, prefooterSlot, "gpt");
    ads.verifyGptAdInSlot(prefooterSlot, lineItemId, "");
  }

  @Test(
      groups = {"TestAdsOnFilePages_GeoEdgeFree"},
      dataProviderClass = AdsDataProvider.class,
      dataProvider = "filePages"
  )
  public void TestAdsOnFilePages_GeoEdgeFree(String wikiName, String article, String lineItemId,
                                             String adUnit, String leaderboardSlot,
                                             String medrecSlot,
                                             Dimension resolution) throws Exception {
    String testedPage = urlBuilder.getUrlForPath(wikiName, article);
    AdsBaseObject ads = new AdsBaseObject(driver, testedPage, resolution);

    ads.verifyGptIframe(adUnit, leaderboardSlot, "gpt");
    ads.verifyGptAdInSlot(leaderboardSlot, lineItemId, "");
    ads.verifyGptIframe(adUnit, medrecSlot, "gpt");
    ads.verifyGptAdInSlot(medrecSlot, lineItemId, "");
  }


}
