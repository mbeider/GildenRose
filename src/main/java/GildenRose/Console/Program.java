package GildenRose.Console;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public ArrayList<Item> Items;

    public static void main(String[] args)
    {
        System.out.println("OMGHAI!");

        var app = new Program();
        app.Items = new ArrayList<Item>();
        app.Items.add(new Item("+5 Dexterity Vest", 10, 20));
        app.Items.add(new Item("Aged Brie", 2, 0));
        app.Items.add(new Item("Elixir of the Mongoose", 5, 7));
        app.Items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        app.Items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        app.Items.add(new Item("Conjured Mana Cake", 3, 6));

        app.UpdateQuality();

        System.out.println("Press enter to exit...");
        var scan = new Scanner(System.in);
        scan.nextLine();
        scan.close();
    }

    public void UpdateQuality() {
        for (int i = 0; i < Items.size(); i++) {
            if (!Items.get(i).getName().equals("Aged Brie")
                    && !Items.get(i).getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (Items.get(i).getQuality() > 0) {
                    if (!Items.get(i).getName().equals("Sulfuras, Hand of Ragnaros")) {
                        Items.get(i).setQuality(Items.get(i).getQuality() - 1);
                    }
                }
            } else {
                if (Items.get(i).getQuality() < 50) {
                    Items.get(i).setQuality(Items.get(i).getQuality() + 1);

                    if (Items.get(i).getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (Items.get(i).getSellIn() < 11) {
                            if (Items.get(i).getQuality() < 50) {
                                Items.get(i).setQuality(Items.get(i).getQuality() + 1);
                            }
                        }

                        if (Items.get(i).getSellIn() < 6) {
                            if (Items.get(i).getQuality() < 50) {
                                Items.get(i).setQuality(Items.get(i).getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!Items.get(i).getName().equals("Sulfuras, Hand of Ragnaros")) {
                Items.get(i).setSellIn(Items.get(i).getSellIn() - 1);
            }

            if (Items.get(i).getSellIn() < 0) {
                if (!Items.get(i).getName().equals("Aged Brie")) {
                    if (!Items.get(i).getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (Items.get(i).getQuality() > 0) {
                            if (!Items.get(i).getName().equals("Sulfuras, Hand of Ragnaros")) {
                                Items.get(i).setQuality(Items.get(i).getQuality() - 1);
                            }
                        }
                    } else {
                        Items.get(i).setQuality(Items.get(i).getQuality() - Items.get(i).getQuality());
                    }
                } else {
                    if (Items.get(i).getQuality() < 50) {
                        Items.get(i).setQuality(Items.get(i).getQuality() + 1);
                    }
                }
            }
        }
    }
}