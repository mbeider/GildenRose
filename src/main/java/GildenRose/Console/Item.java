package GildenRose.Console;

public class Item {
  private String name;
  private int sellIn;
  private int quality;

  public Item(String name, int sellIn, int quality) {
    setName(name);
    setSellIn(sellIn);
    setQuality(quality);
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public int getSellIn() {
    return sellIn;
  }
  public void setSellIn(int sellIn) {
    this.sellIn = sellIn;
  }

  public int getQuality() {
    return quality;
  }
  public void setQuality(int quality) {
    this.quality = quality;
  }

  public void UpdateQuality() {
    if (!this.getName().equals("Aged Brie")
            && !this.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
      if (this.getQuality() > 0) {
        if (!this.getName().equals("Sulfuras, Hand of Ragnaros")) {
          this.setQuality(this.getQuality() - 1);
        }
      }
    } else {
      if (this.getQuality() < 50) {
        this.setQuality(this.getQuality() + 1);

        if (this.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (this.getSellIn() < 11) {
            if (this.getQuality() < 50) {
              this.setQuality(this.getQuality() + 1);
            }
          }

          if (this.getSellIn() < 6) {
            if (this.getQuality() < 50) {
              this.setQuality(this.getQuality() + 1);
            }
          }
        }
      }
    }

    if (!this.getName().equals("Sulfuras, Hand of Ragnaros")) {
      this.setSellIn(this.getSellIn() - 1);
    }

    if (this.getSellIn() < 0) {
      if (!this.getName().equals("Aged Brie")) {
        if (!this.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (this.getQuality() > 0) {
            if (!this.getName().equals("Sulfuras, Hand of Ragnaros")) {
              this.setQuality(this.getQuality() - 1);
            }
          }
        } else {
          this.setQuality(this.getQuality() - this.getQuality());
        }
      } else {
        if (this.getQuality() < 50) {
          this.setQuality(this.getQuality() + 1);
        }
      }
    }
  }
}