package enumvalues;

public enum StartingProductAmount {

    TOMATO_SAUCE("Tomato sauce", 3750), DOUGH("Dough", 8000), BASIL("Basil", 600),
    TAGLIATELLE("Tagliatelle", 4000), SPAGHETTI("Spaghetti", 2000),
    LASAGNA_CRUSTS("Lasagna crusts", 1400), MOZZARELLA("Mozzarella", 3500),
    PARMESAN("Parmesan", 4200), ONION("Onion", 1800), CORN("Corn", 900),
    TOMATO("Tomato", 1800), MUSHROOMS("Mushrooms", 3500), OLIVES("Olives", 900),
    CARROTS("Carrots", 1800), BROCCOLI("Broccoli", 900),
    CHICKEN_FILLET("Chicken fillet", 4500), BACON("Bacon", 2500),
    PROSCIUTTO("Prosciutto", 1200), EGG("Egg", 500),
    MINCED_MEAT("Minced meat", 3000), COOKING_CREAM("Cooking cream", 2300),
    RICE("Rice", 4200), SAUVIGNON_BLANC_WINE("Sauvignon Blanc Wine", 8000),
    CHARDONNAY_WINE("Chardonnay Wine", 5000), ROSE_WINE("Rosé Wine", 5000),
    WATER("Water", 10000), SODA("Soda", 8000);

    private String name;
    private int grams;

    StartingProductAmount(String name, int grams) {
        this.name = name;
        this.grams = grams;
    }

    public String getName() {
        return name;
    }

    public int getGrams() {
        return grams;
    }
}