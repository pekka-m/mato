/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uusmatotesti.PisteKokeilu;

/**
 *
 * @author Aleksi
 */
public class NimiToPiste {

    private static String NimiToPisteet;

    public static String getNimiToPisteet() {
        System.out.println(NimiToPisteet);
        return NimiToPisteet;
    }

    public static void setNimiToPisteet(String NimiToPisteet) {
        NimiToPiste.NimiToPisteet = NimiToPisteet;
    }
}
