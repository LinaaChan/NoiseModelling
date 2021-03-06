/**
 * NoiseMap is a scientific computation plugin for OrbisGIS developed in order to
 * evaluate the noise impact on urban mobility plans. This model is
 * based on the French standard method NMPB2008. It includes traffic-to-noise
 * sources evaluation and sound propagation processing.
 *
 * This version is developed at French IRSTV Institute and at IFSTTAR
 * (http://www.ifsttar.fr/) as part of the Eval-PDU project, funded by the
 * French Agence Nationale de la Recherche (ANR) under contract ANR-08-VILL-0005-01.
 *
 * Noisemap is distributed under GPL 3 license. Its reference contact is Judicaël
 * Picaut <judicael.picaut@ifsttar.fr>. It is maintained by Nicolas Fortin
 * as part of the "Atelier SIG" team of the IRSTV Institute <http://www.irstv.fr/>.
 *
 * Copyright (C) 2011 IFSTTAR
 * Copyright (C) 2011-2012 IRSTV (FR CNRS 2488)
 *
 * Noisemap is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * Noisemap is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Noisemap. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <http://www.orbisgis.org/>
 * or contact directly:
 * info_at_ orbisgis.org
 */
package org.orbisgis.noisemap.core;

import java.util.HashMap;

/**
 * This class store the attenuation value of Tram emission spectrum.
 * @author Nicolas Fortin
 */
public class TramSpectrumRepartition {

    private static final HashMap<Integer, Integer> freqToIndex;

    static {
        freqToIndex = new HashMap<Integer, Integer>();
        freqToIndex.put(100, 0);
        freqToIndex.put(125, 1);
        freqToIndex.put(160, 2);
        freqToIndex.put(200, 3);
        freqToIndex.put(250, 4);
        freqToIndex.put(315, 5);
        freqToIndex.put(400, 6);
        freqToIndex.put(500, 7);
        freqToIndex.put(630, 8);
        freqToIndex.put(800, 9);
        freqToIndex.put(1000, 10);
        freqToIndex.put(1250, 11);
        freqToIndex.put(1600, 12);
        freqToIndex.put(2000, 13);
        freqToIndex.put(2500, 14);
        freqToIndex.put(3150, 15);
        freqToIndex.put(4000, 16);
        freqToIndex.put(5000, 17);
    }
	private final static double[] non_pervious_att = { -11.3, -11.3, -11.3, -11.3, -11.3 ,-11.3,-11.3,
			-11.3, -11.3, -11.3, -11.3, -11.3, -16.3, -16.3, -16.3, -21.3, -21.3, -21.3 };

    /**
     * Utility class
     */
	private TramSpectrumRepartition() {
	}

    /**
     * @param freq Frequency Hz, one of [100,125,160,200,250,315,400,500,630,800,1000,1250,1600,2000,2500,3150,4000,5000]
     * @return dB(A) attenuation value corresponding to the the third octave frequency band
     * @throws IllegalArgumentException
     */
	public static double getAttenuatedValue(int freq) throws IllegalArgumentException {
		if (freqToIndex.containsKey(freq)) {
			return non_pervious_att[freqToIndex.get(freq)];
		} else {
			throw new IllegalArgumentException("The frequency " + freq
					+ " Hz is unknown !");
		}
	}
}
