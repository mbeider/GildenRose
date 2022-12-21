package GildenRose.Console;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

public class GildedRoseTest {
  @Test
  void normalItemBeforeSellDate() {
    Item normalItem = new Item("Normal Item", 5, 10);
    normalItem.UpdateQuality();
    assertDaysRemainingAndQuality(normalItem, 4, 9);
  }

  @Test
  void normalItemOnSellDate() {
    Item normalItem = new Item("Normal Item", 0, 10);
    normalItem.UpdateQuality();
    assertDaysRemainingAndQuality(normalItem, -1, 8);
  }

  @Test
  void normalItemAfterSellDate() {
    Item normalItem = new Item("Normal Item", -10, 10);
    normalItem.UpdateQuality();
    assertDaysRemainingAndQuality(normalItem, -11, 8);
  }

  @Test
  void normalItemOfZeroQuality() {
    Item normalItem = new Item("Normal Item", 5, 0);
    normalItem.UpdateQuality();
    assertDaysRemainingAndQuality(normalItem, 4, 0);
  }

  @Test
  void agedBrieBeforeSellDate() {
    Item brie = new Item("Aged Brie", 5, 10);
    brie.UpdateQuality();
    assertDaysRemainingAndQuality(brie, 4, 11);
  }

  @Test
  void agedBrieWithMaxQuality() {
    Item brie = new Item("Aged Brie", 5, 50);
    brie.UpdateQuality();
    assertDaysRemainingAndQuality(brie, 4, 50);
  }

  @Test
  void agedBrieOnSellDate() {
    Item brie = new Item("Aged Brie", 0, 10);
    brie.UpdateQuality();
    assertDaysRemainingAndQuality(brie, -1, 12);
  }

  @Test
  void agedBrieOnSellDateNearMaxQuality() {
    Item brie = new Item("Aged Brie", 0, 49);
    brie.UpdateQuality();
    assertDaysRemainingAndQuality(brie, -1, 50);
  }

  @Test
  void agedBrieOnSellDateWithMaxQuality() {
    Item brie = new Item("Aged Brie", 0, 50);
    brie.UpdateQuality();
    assertDaysRemainingAndQuality(brie, -1, 50);
  }

  @Test
  void agedBrieAfterSellDate() {
    Item brie = new Item("Aged Brie", -10, 10);
    brie.UpdateQuality();
    assertDaysRemainingAndQuality(brie, -11, 12);
  }

  @Test
  void agedBrieAfterSellDateWithMaxQuality() {
    Item brie = new Item("Aged Brie", -10, 50);
    brie.UpdateQuality();
    assertDaysRemainingAndQuality(brie, -11, 50);
  }

  @Test
  void sulfurasBeforeSellDate() {
    Item sulfuras = new Item("Legendary Sulfuras, Hand of Ragnaros", 5, 80);
    sulfuras.UpdateQuality();
    assertDaysRemainingAndQuality(sulfuras, 4, 79);
  }

  @Test
  void sulfurasOnSellDate() {
    Item sulfuras = new Item("Legendary Sulfuras, Hand of Ragnaros", 0, 80);
    sulfuras.UpdateQuality();
    assertDaysRemainingAndQuality(sulfuras, -1, 78);
  }

  @Test
  void sulfurasAfterSellDate() {
    Item sulfuras = new Item("Legendary Sulfuras, Hand of Ragnaros", -10, 80);
    sulfuras.UpdateQuality();
    assertDaysRemainingAndQuality(sulfuras, -11, 78);
  }

  @Test
  void backstagePassLongBeforeSellDate() {
    Item tafkal = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10);
    tafkal.UpdateQuality();
    assertDaysRemainingAndQuality(tafkal, 10, 11);
  }

  @Test
  void backstagePassLongBeforeSellDateAtMaxQuality() {
    Item tafkal = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50);
    tafkal.UpdateQuality();
    assertDaysRemainingAndQuality(tafkal, 10, 50);
  }

  @Test
  void backstagePassMediumCloseToSellDateUpperBound() {
    Item tafkal = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
    tafkal.UpdateQuality();
    assertDaysRemainingAndQuality(tafkal, 9, 12);
  }

  @Test
  void backstagePassMediumCloseToSellDateUpperBoundAtMaxQuality() {
    Item tafkal = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50);
    tafkal.UpdateQuality();
    assertDaysRemainingAndQuality(tafkal, 9, 50);
  }

  @Test
  void backstagePassMediumCloseToSellDateLowerBound() {
    Item tafkal = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10);
    tafkal.UpdateQuality();
    assertDaysRemainingAndQuality(tafkal, 5, 12);
  }

  @Test
  void backstagePassMediumCloseToSellDateLowerBoundAtMaxQuality() {
    Item tafkal = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 50);
    tafkal.UpdateQuality();
    assertDaysRemainingAndQuality(tafkal, 5, 50);
  }

  @Test
  void backstagePassVeryCloseToSellDateUpperBound() {
    Item tafkal = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
    tafkal.UpdateQuality();
    assertDaysRemainingAndQuality(tafkal, 4, 13);
  }

  @Test
  void backstagePassVeryCloseToSellDateUpperBoundAtMaxQuality() {
    Item tafkal = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50);
    tafkal.UpdateQuality();
    assertDaysRemainingAndQuality(tafkal, 4, 50);
  }

  @Test
  void backstagePassVeryCloseToSellDateLowerBound() {
    Item tafkal = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10);
    tafkal.UpdateQuality();
    assertDaysRemainingAndQuality(tafkal, 0, 13);
  }

  @Test
  void backstagePassVeryCloseToSellDateLowerBoundAtMaxQuality() {
    Item tafkal = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50);
    tafkal.UpdateQuality();
    assertDaysRemainingAndQuality(tafkal, 0, 50);
  }

  @Test
  void backstagePassOnSellDate() {
    Item tafkal = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
    tafkal.UpdateQuality();
    assertDaysRemainingAndQuality(tafkal, -1, 0);
  }

  @Test
  void backstagePassAfterSellDate() {
    Item tafkal = new Item("Backstage passes to a TAFKAL80ETC concert", -10, 10);
    tafkal.UpdateQuality();
    assertDaysRemainingAndQuality(tafkal, -11, 0);
  }

  @Test
  void conjuredManaBeforeSellDate() {
    Item cake = new Item("Conjured Mana Cake", 5, 10);
    cake.UpdateQuality();
    assertDaysRemainingAndQuality(cake, 4, 9);
  }

  @Test
  void conjuredManaBeforeSellDateAtZeroQuality() {
    Item cake = new Item("Conjured Mana Cake", 5, 0);
    cake.UpdateQuality();
    assertDaysRemainingAndQuality(cake, 4, 0);
  }

   @Test
  void conjuredManaOnSellDate() {
    Item cake = new Item("Conjured Mana Cake", 0, 10);
     cake.UpdateQuality();
    assertDaysRemainingAndQuality(cake, -1, 8);
  }

  @Test
  void conjuredManaOnSellDateAtZeroQuality() {
    Item cake = new Item("Conjured Mana Cake", 0, 0);
    cake.UpdateQuality();
    assertDaysRemainingAndQuality(cake, -1, 0);
  }

  @Test
  void conjuredManaAfterSellDate() {
    Item cake = new Item("Conjured Mana Cake", -10, 10);
    cake.UpdateQuality();
    assertDaysRemainingAndQuality(cake, -11, 8);
  }

  @Test
  void conjuredManaAfterSellDateAtZeroQuality() {
    Item cake = new Item("Conjured Mana Cake", -10, 0);
    cake.UpdateQuality();
    assertDaysRemainingAndQuality(cake, -11, 0);
  }

  /**
   * Assertion helper to simplify test cases.
   * 
   * @param rose          The object under test. Its sellIn and getQuality will be compared.
   * @param sellIn        The expected sellIn to compare.
   * @param quality       The expected quality to compare.
   */
  private void assertDaysRemainingAndQuality(Item rose, int sellIn, int quality) {
    StringBuilder errorBuilder = new StringBuilder();

    boolean daysRemainingError = sellIn != rose.getSellIn();
    if (daysRemainingError == true) {
      errorBuilder.append("Expected sellIn <").append(sellIn).append("> but was <").append(rose.getSellIn()).append(">.");
    }

    boolean qualityError = quality != rose.getQuality();
    if (qualityError == true) {
      if (daysRemainingError == true) {
        errorBuilder.append(" ");
      }
      errorBuilder.append("Expected quality <").append(quality).append("> but was <").append(rose.getQuality()).append(">.");
    }

    if (qualityError == true || daysRemainingError == true) {
      throw new AssertionFailedError(errorBuilder.toString());
    }
  }
}
