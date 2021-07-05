/*
 * Copyright (c) 1995, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package java.awt;

import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;

/**
 * The <code>Color</code> class is used to encapsulate colors in the default
 * sRGB color space or colors in arbitrary color spaces identified by a
 * {@link ColorSpace}.  Every color has an implicit alpha value of 1.0 or
 * an explicit one provided in the constructor.  The alpha value
 * defines the transparency of a color and can be represented by
 * a float value in the range 0.0&nbsp;-&nbsp;1.0 or 0&nbsp;-&nbsp;255.
 * An alpha value of 1.0 or 255 means that the color is completely
 * opaque and an alpha value of 0 or 0.0 means that the color is
 * completely transparent.
 * When constructing a <code>Color</code> with an explicit alpha or
 * getting the color/alpha components of a <code>Color</code>, the color
 * components are never premultiplied by the alpha component.
 * <p>
 * The default color space for the Java 2D(tm) API is sRGB, a proposed
 * standard RGB color space.  For further information on sRGB,
 * see <A href="http://www.w3.org/pub/WWW/Graphics/Color/sRGB.html">
 * http://www.w3.org/pub/WWW/Graphics/Color/sRGB.html
 * </A>.
 * <p>
 * @version     10 Feb 1997
 * @author      Sami Shaio
 * @author      Arthur van Hoff
 * @see         ColorSpace
 * @see         AlphaComposite
 */
public class Color1 extends Color implements Paint, java.io.Serializable {

    /**
     * The color white.  In the default sRGB space.
     */
    public final static Color white     = new Color(255, 255, 255);

    /**
     * The color white.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color WHITE = white;

    /**
     * The color light gray.  In the default sRGB space.
     */
    public final static Color lightGray = new Color(192, 192, 192);

    /**
     * The color light gray.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color LIGHT_GRAY = lightGray;

    /**
     * The color gray.  In the default sRGB space.
     */
    public final static Color gray      = new Color(128, 128, 128);

    /**
     * The color gray.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color GRAY = gray;

    /**
     * The color dark gray.  In the default sRGB space.
     */
    public final static Color darkGray  = new Color(64, 64, 64);

    /**
     * The color dark gray.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color DARK_GRAY = darkGray;

    /**
     * The color black.  In the default sRGB space.
     */
    public final static Color black     = new Color(0, 0, 0);

    /**
     * The color black.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color BLACK = black;

    /**
     * The color red.  In the default sRGB space.
     */
    public final static Color red       = new Color(255, 0, 0);

    /**
     * The color red.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color RED = red;

    /**
     * The color pink.  In the default sRGB space.
     */
    public final static Color pink      = new Color(255, 175, 175);

    /**
     * The color pink.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color PINK = pink;

    /**
     * The color orange.  In the default sRGB space.
     */
    public final static Color orange    = new Color(255, 200, 0);

    /**
     * The color orange.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color ORANGE = orange;

    /**
     * The color yellow.  In the default sRGB space.
     */
    public final static Color yellow    = new Color(255, 255, 0);

    /**
     * The color yellow.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color YELLOW = yellow;

    /**
     * The color green.  In the default sRGB space.
     */
    public final static Color green     = new Color(0, 255, 0);

    /**
     * The color green.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color GREEN = green;

    /**
     * The color magenta.  In the default sRGB space.
     */
    public final static Color magenta   = new Color(255, 0, 255);

    /**
     * The color magenta.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color MAGENTA = magenta;

    /**
     * The color cyan.  In the default sRGB space.
     */
    public final static Color cyan      = new Color(0, 255, 255);

    /**
     * The color cyan.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color CYAN = cyan;

    /**
     * The color crask.  In the default sRGB space.
     */
    public final static Color crask      = new Color(240, 16, 32);

    /**
     * The color crask.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color CRASK = crask;

    /**
     * The color ffc08040.  In the default sRGB space.
     */
    public final static Color colorFFc08040 = new Color(192, 128, 64);

    /**
     * The color ffc08040.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color COLORFFC08040 = colorFFc08040;

    /**
     * The color blue.  In the default sRGB space.
     */
    public final static Color blue      = new Color(0, 0, 255);

    /**
     * The color blue.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color BLUE = blue;

    /**
     * The color purple.  In the default sRGB space.
     */
    public final static Color purple      = new Color(128, 0, 255);

    /**
     * The color purple.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color PURPLE = purple;

    /**
     * The color light_purple.  In the default sRGB space.
     */
    public final static Color light_purple      = new Color(192, 0, 255);

    /**
     * The color light_purple.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color LIGHT_PURPLE = light_purple;

    /**
     * The color aqua.  In the default sRGB space.
     */
    public final static Color aqua      = new Color(64, 192, 255);

    /**
     * The color light_purple.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color AQUA = aqua;

    public final static Color getColor_802000FF      = new Color(128, 32, 0, 255);
    public final static Color getColor_C8C8C8FF      = new Color(200, 200, 200, 255);
    public final static Color getColor_FF5060FF      = new Color(255, 80, 96, 255);
    public final static Color getColor_80146499      = new Color(128, 20, 100, 153);
    public final static Color getColor_B40000FF      = new Color(180, 0, 0, 255);
    public final static Color getColor_BE6464FF      = new Color(190, 100, 100, 255);
    public final static Color getColor_FFFF80FF      = new Color(255, 255, 128, 255);
    public final static Color getColor_FFC080FF      = new Color(255, 192, 128, 255);
    public final static Color getColor_FFA080FF      = new Color(255, 160, 128, 255);
    public final static Color getColor_804000FF      = new Color(128, 64, 0, 255);
    public final static Color getColor_C08040FF      = new Color(192, 128, 64, 255);
    public final static Color getColor_FF3F76E4      = new Color(255, 63, 118, 228);
    public final static Color getColor_A000FFE3      = new Color(160, 0, 255, 227);
    public final static Color getColor_FF000000      = new Color(255, 0, 0, 0);
    public final static Color getColor_A000FF00      = new Color(160, 0, 255, 0);
    public final static Color getColor_A000FFFF      = new Color(160, 0, 255, 255);
    /**
     * The color.  In the default sRGB space.
     * @since 1.4
     */
    public final static Color Color802000FF = getColor_802000FF;
    public final static Color ColorC8C8C8FF = getColor_C8C8C8FF;
    public final static Color ColorFF5060FF = getColor_FF5060FF;
    public final static Color Color80146499 = getColor_80146499;
    public final static Color ColorB40000FF = getColor_B40000FF;
    public final static Color ColorBE6464FF = getColor_BE6464FF;
    public final static Color ColorFFFF80FF = getColor_FFFF80FF;
    public final static Color ColorFFC080FF = getColor_FFC080FF;
    public final static Color ColorFFA080FF = getColor_FFA080FF;
    public final static Color Color804000FF = getColor_804000FF;
    public final static Color ColorC08040FF = getColor_C08040FF;
    /**
     * The color value.
     * @serial
     * @see #getRGB
     */
    int value;

    /**
     * The color value in the default sRGB <code>ColorSpace</code> as
     * <code>float</code> components (no alpha).
     * If <code>null</code> after object construction, this must be an
     * sRGB color constructed with 8-bit precision, so compute from the
     * <code>int</code> color value.
     * @serial
     * @see #getRGBColorComponents
     * @see #getRGBComponents
     */
    private float frgbvalue[] = null;

    /**
     * The color value in the native <code>ColorSpace</code> as
     * <code>float</code> components (no alpha).
     * If <code>null</code> after object construction, this must be an
     * sRGB color constructed with 8-bit precision, so compute from the
     * <code>int</code> color value.
     * @serial
     * @see #getRGBColorComponents
     * @see #getRGBComponents
     */
    private float fvalue[] = null;

    /**
     * The alpha value as a <code>float</code> component.
     * If <code>frgbvalue</code> is <code>null</code>, this is not valid
     * data, so compute from the <code>int</code> color value.
     * @serial
     * @see #getRGBComponents
     * @see #getComponents
     */
    private float falpha = 0.0f;

    /**
     * The <code>ColorSpace</code>.  If <code>null</code>, then it's
     * default is sRGB.
     * @serial
     * @see #getColor
     * @see #getColorSpace
     * @see #getColorComponents
     */
    private ColorSpace cs = null;

    /*
     * JDK 1.1 serialVersionUID
     */
    private static final long serialVersionUID = 118526816881161077L;

    public Color1(int r, int g, int b) {
        super(r, g, b);
    }

    /**
     * Initialize JNI field and method IDs
     */
    private static native void initIDs();

    static {
        /** 4112352 - Calling getDefaultToolkit()
         ** here can cause this class to be accessed before it is fully
         ** initialized. DON'T DO IT!!!
         **
         ** Toolkit.getDefaultToolkit();
         **/

        /* ensure that the necessary native libraries are loaded */
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
    }

    /**
     * Checks the color integer components supplied for validity.
     * Throws an {@link IllegalArgumentException} if the value is out of
     * range.
     * @param r the Red component
     * @param g the Green component
     * @param b the Blue component
     **/
    private static void testColorValueRange(int r, int g, int b, int a) {
        boolean rangeError = false;
        String badComponentString = "";

        if ( a < 0 || a > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Alpha";
        }
        if ( r < 0 || r > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Red";
        }
        if ( g < 0 || g > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Green";
        }
        if ( b < 0 || b > 255) {
            rangeError = true;
            badComponentString = badComponentString + " Blue";
        }
        if ( rangeError == true ) {
            throw new IllegalArgumentException("Color parameter outside of expected range:"
                    + badComponentString);
        }
    }

    /**
     * Checks the color <code>float</code> components supplied for
     * validity.
     * Throws an <code>IllegalArgumentException</code> if the value is out
     * of range.
     * @param r the Red component
     * @param g the Green component
     * @param b the Blue component
     **/
    private static void testColorValueRange(float r, float g, float b, float a) {
        boolean rangeError = false;
        String badComponentString = "";
        if ( a < 0.0 || a > 1.0) {
            rangeError = true;
            badComponentString = badComponentString + " Alpha";
        }
        if ( r < 0.0 || r > 1.0) {
            rangeError = true;
            badComponentString = badComponentString + " Red";
        }
        if ( g < 0.0 || g > 1.0) {
            rangeError = true;
            badComponentString = badComponentString + " Green";
        }
        if ( b < 0.0 || b > 1.0) {
            rangeError = true;
            badComponentString = badComponentString + " Blue";
        }
        if ( rangeError == true ) {
            throw new IllegalArgumentException("Color parameter outside of expected range:"
                    + badComponentString);
        }
    }

    /**
     * Returns the red component in the range 0-255 in the default sRGB
     * space.
     * @return the red component.
     * @see #getRGB
     */
    public int getRed() {
        return (getRGB() >> 16) & 0xFF;
    }

    /**
     * Returns the green component in the range 0-255 in the default sRGB
     * space.
     * @return the green component.
     * @see #getRGB
     */
    public int getGreen() {
        return (getRGB() >> 8) & 0xFF;
    }

    /**
     * Returns the blue component in the range 0-255 in the default sRGB
     * space.
     * @return the blue component.
     * @see #getRGB
     */
    public int getBlue() {
        return (getRGB() >> 0) & 0xFF;
    }

    /**
     * Returns the alpha component in the range 0-255.
     * @return the alpha component.
     * @see #getRGB
     */
    public int getAlpha() {
        return (getRGB() >> 24) & 0xff;
    }

    /**
     * Returns the RGB value representing the color in the default sRGB
     * {@link ColorModel}.
     * (Bits 24-31 are alpha, 16-23 are red, 8-15 are green, 0-7 are
     * blue).
     * @return the RGB value of the color in the default sRGB
     *         <code>ColorModel</code>.
     * @see ColorModel#getRGBdefault
     * @see #getRed
     * @see #getGreen
     * @see #getBlue
     * @since JDK1.0
     */
    public int getRGB() {
        return value;
    }

    private static final double FACTOR = 0.7;

    /**
     * Creates a new <code>Color</code> that is a brighter version of this
     * <code>Color</code>.
     * <p>
     * This method applies an arbitrary scale factor to each of the three RGB
     * components of this <code>Color</code> to create a brighter version
     * of this <code>Color</code>.
     * The {@code alpha} value is preserved.
     * Although <code>brighter</code> and
     * <code>darker</code> are inverse operations, the results of a
     * series of invocations of these two methods might be inconsistent
     * because of rounding errors.
     * @return     a new <code>Color</code> object that is
     *                 a brighter version of this <code>Color</code>
     *                 with the same {@code alpha} value.
     * @see        Color#darker
     * @since      JDK1.0
     */
    public Color brighter() {
        int red = getRed();
        int green = getGreen();
        int blue = getBlue();
        int alpha = getAlpha();

        /* From 2D group:
         * 1. black.brighter() should return grey
         * 2. applying brighter to blue will always return blue, brighter
         * 3. non pure color (non zero rgb) will eventually return white
         */
        int i = (int)(1.0/(1.0-FACTOR));
        if ( red == 0 && green == 0 && blue == 0) {
            return new Color(i, i, i, alpha);
        }
        if ( red > 0 && red < i ) red = i;
        if ( green > 0 && green < i ) green = i;
        if ( blue > 0 && blue < i ) blue = i;

        return new Color(Math.min((int)(red/FACTOR), 255),
                Math.min((int)(green/FACTOR), 255),
                Math.min((int)(blue/FACTOR), 255),
                alpha);
    }

    /**
     * Creates a new <code>Color</code> that is a darker version of this
     * <code>Color</code>.
     * <p>
     * This method applies an arbitrary scale factor to each of the three RGB
     * components of this <code>Color</code> to create a darker version of
     * this <code>Color</code>.
     * The {@code alpha} value is preserved.
     * Although <code>brighter</code> and
     * <code>darker</code> are inverse operations, the results of a series
     * of invocations of these two methods might be inconsistent because
     * of rounding errors.
     * @return  a new <code>Color</code> object that is
     *                    a darker version of this <code>Color</code>
     *                    with the same {@code alpha} value.
     * @see        Color#brighter
     * @since      JDK1.0
     */
    public Color darker() {
        return new Color(Math.max((int)(getRed()  *FACTOR), 0),
                Math.max((int)(getGreen()*FACTOR), 0),
                Math.max((int)(getBlue() *FACTOR), 0),
                getAlpha());
    }

    /**
     * Computes the hash code for this <code>Color</code>.
     * @return     a hash code value for this object.
     * @since      JDK1.0
     */
    public int hashCode() {
        return value;
    }

    /**
     * Determines whether another object is equal to this
     * <code>Color</code>.
     * <p>
     * The result is <code>true</code> if and only if the argument is not
     * <code>null</code> and is a <code>Color</code> object that has the same
     * red, green, blue, and alpha values as this object.
     * @param       obj   the object to test for equality with this
     *                          <code>Color</code>
     * @return      <code>true</code> if the objects are the same;
     *                             <code>false</code> otherwise.
     * @since   JDK1.0
     */
    public boolean equals(Object obj) {
        return obj instanceof Color && ((Color)obj).getRGB() == this.getRGB();
    }

    /**
     * Returns a string representation of this <code>Color</code>. This
     * method is intended to be used only for debugging purposes.  The
     * content and format of the returned string might vary between
     * implementations. The returned string might be empty but cannot
     * be <code>null</code>.
     *
     * @return  a string representation of this <code>Color</code>.
     */
    public String toString() {
        return getClass().getName() + "[r=" + getRed() + ",g=" + getGreen() + ",b=" + getBlue() + "]";
    }

    /**
     * Converts a <code>String</code> to an integer and returns the
     * specified opaque <code>Color</code>. This method handles string
     * formats that are used to represent octal and hexadecimal numbers.
     * @param      nm a <code>String</code> that represents
     *                            an opaque color as a 24-bit integer
     * @return     the new <code>Color</code> object.
     * @see        Integer#decode
     * @exception  NumberFormatException  if the specified string cannot
     *                      be interpreted as a decimal,
     *                      octal, or hexadecimal integer.
     * @since      JDK1.1
     */
    public static Color decode(String nm) throws NumberFormatException {
        Integer intval = Integer.decode(nm);
        int i = intval.intValue();
        return new Color((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF);
    }

    /**
     * Finds a color in the system properties.
     * <p>
     * The argument is treated as the name of a system property to
     * be obtained. The string value of this property is then interpreted
     * as an integer which is then converted to a <code>Color</code>
     * object.
     * <p>
     * If the specified property is not found or could not be parsed as
     * an integer then <code>null</code> is returned.
     * @param    nm the name of the color property
     * @return   the <code>Color</code> converted from the system
     *          property.
     * @see      System#getProperty(String)
     * @see      Integer#getInteger(String)
     * @see      Color#Color(int)
     * @since    JDK1.0
     */
    public static Color getColor(String nm) {
        return getColor(nm, null);
    }

    /**
     * Finds a color in the system properties.
     * <p>
     * The first argument is treated as the name of a system property to
     * be obtained. The string value of this property is then interpreted
     * as an integer which is then converted to a <code>Color</code>
     * object.
     * <p>
     * If the specified property is not found or cannot be parsed as
     * an integer then the <code>Color</code> specified by the second
     * argument is returned instead.
     * @param    nm the name of the color property
     * @param    v    the default <code>Color</code>
     * @return   the <code>Color</code> converted from the system
     *          property, or the specified <code>Color</code>.
     * @see      System#getProperty(String)
     * @see      Integer#getInteger(String)
     * @see      Color#Color(int)
     * @since    JDK1.0
     */
    public static Color getColor(String nm, Color v) {
        Integer intval = Integer.getInteger(nm);
        if (intval == null) {
            return v;
        }
        int i = intval.intValue();
        return new Color((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF);
    }

    /**
     * Finds a color in the system properties.
     * <p>
     * The first argument is treated as the name of a system property to
     * be obtained. The string value of this property is then interpreted
     * as an integer which is then converted to a <code>Color</code>
     * object.
     * <p>
     * If the specified property is not found or could not be parsed as
     * an integer then the integer value <code>v</code> is used instead,
     * and is converted to a <code>Color</code> object.
     * @param    name  the name of the color property
     * @param    value   the default color value, as an integer
     * @return   the <code>Color</code> converted from the system
     *          property or the <code>Color</code> converted from
     *          the specified integer.
     * @see      System#getProperty(String)
     * @see      Integer#getInteger(String)
     * @see      Color#Color(int)
     * @since    JDK1.0
     */
    public static Color getColor(String name, int value) {
        Integer intval = Integer.getInteger(name);
        int i = (intval != null) ? intval.intValue() : value;
        return new Color((i >> 16) & 0xFF, (i >> 8) & 0xFF, (i >> 0) & 0xFF);
    }

    /**
     * Converts the components of a color, as specified by the HSB
     * model, to an equivalent set of values for the default RGB model.
     * <p>
     * The <code>saturation</code> and <code>brightness</code> components
     * should be floating-point values between zero and one
     * (numbers in the range 0.0-1.0).  The <code>hue</code> component
     * can be any floating-point number.  The floor of this number is
     * subtracted from it to create a fraction between 0 and 1.  This
     * fractional number is then multiplied by 360 to produce the hue
     * angle in the HSB color model.
     * <p>
     * The integer that is returned by <code>HSBtoRGB</code> encodes the
     * value of a color in bits 0-23 of an integer value that is the same
     * format used by the method {@link #getRGB() getRGB}.
     * This integer can be supplied as an argument to the
     * <code>Color</code> constructor that takes a single integer argument.
     * @param     hue   the hue component of the color
     * @param     saturation   the saturation of the color
     * @param     brightness   the brightness of the color
     * @return    the RGB value of the color with the indicated hue,
     *                            saturation, and brightness.
     * @see       Color#getRGB()
     * @see       Color#Color(int)
     * @see       ColorModel#getRGBdefault()
     * @since     JDK1.0
     */
    public static int HSBtoRGB(float hue, float saturation, float brightness) {
        int r = 0, g = 0, b = 0;
        if (saturation == 0) {
            r = g = b = (int) (brightness * 255.0f + 0.5f);
        } else {
            float h = (hue - (float)Math.floor(hue)) * 6.0f;
            float f = h - (float) Math.floor(h);
            float p = brightness * (1.0f - saturation);
            float q = brightness * (1.0f - saturation * f);
            float t = brightness * (1.0f - (saturation * (1.0f - f)));
            switch ((int) h) {
                case 0:
                    r = (int) (brightness * 255.0f + 0.5f);
                    g = (int) (t * 255.0f + 0.5f);
                    b = (int) (p * 255.0f + 0.5f);
                    break;
                case 1:
                    r = (int) (q * 255.0f + 0.5f);
                    g = (int) (brightness * 255.0f + 0.5f);
                    b = (int) (p * 255.0f + 0.5f);
                    break;
                case 2:
                    r = (int) (p * 255.0f + 0.5f);
                    g = (int) (brightness * 255.0f + 0.5f);
                    b = (int) (t * 255.0f + 0.5f);
                    break;
                case 3:
                    r = (int) (p * 255.0f + 0.5f);
                    g = (int) (q * 255.0f + 0.5f);
                    b = (int) (brightness * 255.0f + 0.5f);
                    break;
                case 4:
                    r = (int) (t * 255.0f + 0.5f);
                    g = (int) (p * 255.0f + 0.5f);
                    b = (int) (brightness * 255.0f + 0.5f);
                    break;
                case 5:
                    r = (int) (brightness * 255.0f + 0.5f);
                    g = (int) (p * 255.0f + 0.5f);
                    b = (int) (q * 255.0f + 0.5f);
                    break;
            }
        }
        return 0xff000000 | (r << 16) | (g << 8) | (b << 0);
    }

    /**
     * Converts the components of a color, as specified by the default RGB
     * model, to an equivalent set of values for hue, saturation, and
     * brightness that are the three components of the HSB model.
     * <p>
     * If the <code>hsbvals</code> argument is <code>null</code>, then a
     * new array is allocated to return the result. Otherwise, the method
     * returns the array <code>hsbvals</code>, with the values put into
     * that array.
     * @param     red   the red component of the color
     * @param     green   the green component of the color
     * @param     blue   the blue component of the color
     * @param     hsbvals  the array used to return the
     *                     three HSB values, or <code>null</code>
     * @return    an array of three elements containing the hue, saturation,
     *                     and brightness (in that order), of the color with
     *                     the indicated red, green, and blue components.
     * @see       Color#getRGB()
     * @see       Color#Color(int)
     * @see       ColorModel#getRGBdefault()
     * @since     JDK1.0
     */
    public static float[] RGBtoHSB(int red, int green, int blue, float[] hsbvals) {
        float hue, saturation, brightness;
        if (hsbvals == null) {
            hsbvals = new float[3];
        }
        int cmax = (red > green) ? red : green;
        if (blue > cmax) cmax = blue;
        int cmin = (red < green) ? red : green;
        if (blue < cmin) cmin = blue;

        brightness = ((float) cmax) / 255.0f;
        if (cmax != 0)
            saturation = ((float) (cmax - cmin)) / ((float) cmax);
        else
            saturation = 0;
        if (saturation == 0)
            hue = 0;
        else {
            float redc = ((float) (cmax - red)) / ((float) (cmax - cmin));
            float greenc = ((float) (cmax - green)) / ((float) (cmax - cmin));
            float bluec = ((float) (cmax - blue)) / ((float) (cmax - cmin));
            if (red == cmax)
                hue = bluec - greenc;
            else if (green == cmax)
                hue = 2.0f + redc - bluec;
            else
                hue = 4.0f + greenc - redc;
            hue = hue / 6.0f;
            if (hue < 0)
                hue = hue + 1.0f;
        }
        hsbvals[0] = hue;
        hsbvals[1] = saturation;
        hsbvals[2] = brightness;
        return hsbvals;
    }

    /**
     * Creates a <code>Color</code> object based on the specified values
     * for the HSB color model.
     * <p>
     * The <code>s</code> and <code>b</code> components should be
     * floating-point values between zero and one
     * (numbers in the range 0.0-1.0).  The <code>h</code> component
     * can be any floating-point number.  The floor of this number is
     * subtracted from it to create a fraction between 0 and 1.  This
     * fractional number is then multiplied by 360 to produce the hue
     * angle in the HSB color model.
     * @param  h   the hue component
     * @param  s   the saturation of the color
     * @param  b   the brightness of the color
     * @return  a <code>Color</code> object with the specified hue,
     *                                 saturation, and brightness.
     * @since   JDK1.0
     */
    public static Color getHSBColor(float h, float s, float b) {
        return new Color(HSBtoRGB(h, s, b));
    }

    /**
     * Returns a <code>float</code> array containing the color and alpha
     * components of the <code>Color</code>, as represented in the default
     * sRGB color space.
     * If <code>compArray</code> is <code>null</code>, an array of length
     * 4 is created for the return value.  Otherwise,
     * <code>compArray</code> must have length 4 or greater,
     * and it is filled in with the components and returned.
     * @param compArray an array that this method fills with
     *                  color and alpha components and returns
     * @return the RGBA components in a <code>float</code> array.
     */
    public float[] getRGBComponents(float[] compArray) {
        float[] f;
        if (compArray == null) {
            f = new float[4];
        } else {
            f = compArray;
        }
        if (frgbvalue == null) {
            f[0] = ((float)getRed())/255f;
            f[1] = ((float)getGreen())/255f;
            f[2] = ((float)getBlue())/255f;
            f[3] = ((float)getAlpha())/255f;
        } else {
            f[0] = frgbvalue[0];
            f[1] = frgbvalue[1];
            f[2] = frgbvalue[2];
            f[3] = falpha;
        }
        return f;
    }

    /**
     * Returns a <code>float</code> array containing only the color
     * components of the <code>Color</code>, in the default sRGB color
     * space.  If <code>compArray</code> is <code>null</code>, an array of
     * length 3 is created for the return value.  Otherwise,
     * <code>compArray</code> must have length 3 or greater, and it is
     * filled in with the components and returned.
     * @param compArray an array that this method fills with color
     *          components and returns
     * @return the RGB components in a <code>float</code> array.
     */
    public float[] getRGBColorComponents(float[] compArray) {
        float[] f;
        if (compArray == null) {
            f = new float[3];
        } else {
            f = compArray;
        }
        if (frgbvalue == null) {
            f[0] = ((float)getRed())/255f;
            f[1] = ((float)getGreen())/255f;
            f[2] = ((float)getBlue())/255f;
        } else {
            f[0] = frgbvalue[0];
            f[1] = frgbvalue[1];
            f[2] = frgbvalue[2];
        }
        return f;
    }

    /**
     * Returns a <code>float</code> array containing the color and alpha
     * components of the <code>Color</code>, in the
     * <code>ColorSpace</code> of the <code>Color</code>.
     * If <code>compArray</code> is <code>null</code>, an array with
     * length equal to the number of components in the associated
     * <code>ColorSpace</code> plus one is created for
     * the return value.  Otherwise, <code>compArray</code> must have at
     * least this length and it is filled in with the components and
     * returned.
     * @param compArray an array that this method fills with the color and
     *          alpha components of this <code>Color</code> in its
     *          <code>ColorSpace</code> and returns
     * @return the color and alpha components in a <code>float</code>
     *          array.
     */
    public float[] getComponents(float[] compArray) {
        if (fvalue == null)
            return getRGBComponents(compArray);
        float[] f;
        int n = fvalue.length;
        if (compArray == null) {
            f = new float[n + 1];
        } else {
            f = compArray;
        }
        for (int i = 0; i < n; i++) {
            f[i] = fvalue[i];
        }
        f[n] = falpha;
        return f;
    }

    /**
     * Returns a <code>float</code> array containing only the color
     * components of the <code>Color</code>, in the
     * <code>ColorSpace</code> of the <code>Color</code>.
     * If <code>compArray</code> is <code>null</code>, an array with
     * length equal to the number of components in the associated
     * <code>ColorSpace</code> is created for
     * the return value.  Otherwise, <code>compArray</code> must have at
     * least this length and it is filled in with the components and
     * returned.
     * @param compArray an array that this method fills with the color
     *          components of this <code>Color</code> in its
     *          <code>ColorSpace</code> and returns
     * @return the color components in a <code>float</code> array.
     */
    public float[] getColorComponents(float[] compArray) {
        if (fvalue == null)
            return getRGBColorComponents(compArray);
        float[] f;
        int n = fvalue.length;
        if (compArray == null) {
            f = new float[n];
        } else {
            f = compArray;
        }
        for (int i = 0; i < n; i++) {
            f[i] = fvalue[i];
        }
        return f;
    }

    /**
     * Returns a <code>float</code> array containing the color and alpha
     * components of the <code>Color</code>, in the
     * <code>ColorSpace</code> specified by the <code>cspace</code>
     * parameter.  If <code>compArray</code> is <code>null</code>, an
     * array with length equal to the number of components in
     * <code>cspace</code> plus one is created for the return value.
     * Otherwise, <code>compArray</code> must have at least this
     * length, and it is filled in with the components and returned.
     * @param cspace a specified <code>ColorSpace</code>
     * @param compArray an array that this method fills with the
     *          color and alpha components of this <code>Color</code> in
     *          the specified <code>ColorSpace</code> and returns
     * @return the color and alpha components in a <code>float</code>
     *          array.
     */
    public float[] getComponents(ColorSpace cspace, float[] compArray) {
        if (cs == null) {
            cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
        }
        float f[];
        if (fvalue == null) {
            f = new float[3];
            f[0] = ((float)getRed())/255f;
            f[1] = ((float)getGreen())/255f;
            f[2] = ((float)getBlue())/255f;
        } else {
            f = fvalue;
        }
        float tmp[] = cs.toCIEXYZ(f);
        float tmpout[] = cspace.fromCIEXYZ(tmp);
        if (compArray == null) {
            compArray = new float[tmpout.length + 1];
        }
        for (int i = 0 ; i < tmpout.length ; i++) {
            compArray[i] = tmpout[i];
        }
        if (fvalue == null) {
            compArray[tmpout.length] = ((float)getAlpha())/255f;
        } else {
            compArray[tmpout.length] = falpha;
        }
        return compArray;
    }

    /**
     * Returns a <code>float</code> array containing only the color
     * components of the <code>Color</code> in the
     * <code>ColorSpace</code> specified by the <code>cspace</code>
     * parameter. If <code>compArray</code> is <code>null</code>, an array
     * with length equal to the number of components in
     * <code>cspace</code> is created for the return value.  Otherwise,
     * <code>compArray</code> must have at least this length, and it is
     * filled in with the components and returned.
     * @param cspace a specified <code>ColorSpace</code>
     * @param compArray an array that this method fills with the color
     *          components of this <code>Color</code> in the specified
     *          <code>ColorSpace</code>
     * @return the color components in a <code>float</code> array.
     */
    public float[] getColorComponents(ColorSpace cspace, float[] compArray) {
        if (cs == null) {
            cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
        }
        float f[];
        if (fvalue == null) {
            f = new float[3];
            f[0] = ((float)getRed())/255f;
            f[1] = ((float)getGreen())/255f;
            f[2] = ((float)getBlue())/255f;
        } else {
            f = fvalue;
        }
        float tmp[] = cs.toCIEXYZ(f);
        float tmpout[] = cspace.fromCIEXYZ(tmp);
        if (compArray == null) {
            return tmpout;
        }
        for (int i = 0 ; i < tmpout.length ; i++) {
            compArray[i] = tmpout[i];
        }
        return compArray;
    }

    /**
     * Returns the <code>ColorSpace</code> of this <code>Color</code>.
     * @return this <code>Color</code> object's <code>ColorSpace</code>.
     */
    public ColorSpace getColorSpace() {
        if (cs == null) {
            cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
        }
        return cs;
    }

    /**
     * Creates and returns a {@link PaintContext} used to
     * generate a solid color field pattern.
     * See the {@link Paint#createContext specification} of the
     * method in the {@link Paint} interface for information
     * on null parameter handling.
     *
     * @param cm the preferred {@link ColorModel} which represents the most convenient
     *           format for the caller to receive the pixel data, or {@code null}
     *           if there is no preference.
     * @param r the device space bounding box
     *                     of the graphics primitive being rendered.
     * @param r2d the user space bounding box
     *                   of the graphics primitive being rendered.
     * @param xform the {@link AffineTransform} from user
     *              space into device space.
     * @param hints the set of hints that the context object can use to
     *              choose between rendering alternatives.
     * @return the {@code PaintContext} for
     *         generating color patterns.
     * @see Paint
     * @see PaintContext
     * @see ColorModel
     * @see Rectangle
     * @see Rectangle2D
     * @see AffineTransform
     * @see RenderingHints
     */
    public synchronized PaintContext createContext(ColorModel cm, Rectangle r,
                                                   Rectangle2D r2d,
                                                   AffineTransform xform,
                                                   RenderingHints hints) {
        return new ColorPaintContext(getRGB(), cm);
    }

    /**
     * Returns the transparency mode for this <code>Color</code>.  This is
     * required to implement the <code>Paint</code> interface.
     * @return this <code>Color</code> object's transparency mode.
     * @see Paint
     * @see Transparency
     * @see #createContext
     */
    public int getTransparency() {
        int alpha = getAlpha();
        if (alpha == 0xff) {
            return Transparency.OPAQUE;
        }
        else if (alpha == 0) {
            return Transparency.BITMASK;
        }
        else {
            return Transparency.TRANSLUCENT;
        }
    }

}
