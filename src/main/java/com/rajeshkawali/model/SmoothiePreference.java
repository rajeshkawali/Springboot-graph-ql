package com.rajeshkawali.model;

/**
 * @author Rajesh_Kawali
 */
public enum SmoothiePreference {

    STRAWBERRY_BANANA("Strawberry Banana"),
    MANGO_PINEAPPLE("Mango Pineapple"),
    BLUEBERRY_SPINACH("Blueberry Spinach"),
    CHOCOLATE_PEANUT_BUTTER("Chocolate Peanut Butter"),
    GREEN_DETOX("Green Detox"),
    AVOCADO_CUCUMBER("Avocado Cucumber"),
    PEACH_GINGER("Peach Ginger"),
    MIXED_BERRY("Mixed Berry"),
    TROPICAL_TWIST("Tropical Twist"),
    CARAMEL_LATTE("Caramel Latte");

    private final String smoothieName;

    SmoothiePreference(String smoothieName) {
        this.smoothieName = smoothieName;
    }

    public String getSmoothieName() {
        return smoothieName;
    }
}