/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kvmath.utils;

/**
 *
 * @author callum
 */
public final class ArrayUtils {

    public static long[] toLongArray(int[] in) {
        long[] nw = new long[in.length];
        for (int i = 0; i < nw.length; ++i) {
            nw[i] = (long) in[i];
        }
        return nw;
    }

    public static long[] toLongArray(float[] in) {
        long[] nw = new long[in.length];
        for (int i = 0; i < nw.length; ++i) {
            nw[i] = (long) in[i];
        }
        return nw;
    }

    public static long[] toLongArray(double[] in) {
        long[] nw = new long[in.length];
        for (int i = 0; i < nw.length; ++i) {
            nw[i] = (long) in[i];
        }
        return nw;
    }

    public static int[] toIntArray(long[] in) {
        int[] nw = new int[in.length];
        for (int i = 0; i < nw.length; ++i) {
            nw[i] = (int) in[i];
        }
        return nw;
    }

    public static int[] toIntArray(double[] in) {
        int[] nw = new int[in.length];
        for (int i = 0; i < nw.length; ++i) {
            nw[i] = (int) in[i];
        }
        return nw;
    }

    public static int[] toIntArray(float[] in) {
        int[] nw = new int[in.length];
        for (int i = 0; i < nw.length; ++i) {
            nw[i] = (int) in[i];
        }
        return nw;
    }

    public static float[] toFloatArray(long[] in) {
        float[] nw = new float[in.length];
        for (int i = 0; i < nw.length; ++i) {
            nw[i] = (float) in[i];
        }
        return nw;
    }

    public static float[] toFloatArray(int[] in) {
        float[] nw = new float[in.length];
        for (int i = 0; i < nw.length; ++i) {
            nw[i] = (float) in[i];
        }
        return nw;
    }

    public static float[] toFloatArray(double[] in) {
        float[] nw = new float[in.length];
        for (int i = 0; i < nw.length; ++i) {
            nw[i] = (float) in[i];
        }
        return nw;
    }

    public static double[] toDoubleArray(long[] in) {
        double[] nw = new double[in.length];
        for (int i = 0; i < nw.length; ++i) {
            nw[i] = (double) in[i];
        }
        return nw;
    }

    public static double[] toDoubleArray(int[] in) {
        double[] nw = new double[in.length];
        for (int i = 0; i < nw.length; ++i) {
            nw[i] = (double) in[i];
        }
        return nw;
    }

    public static double[] toDoubleArray(float[] in) {
        double[] nw = new double[in.length];
        for (int i = 0; i < nw.length; ++i) {
            nw[i] = (double) in[i];
        }
        return nw;
    }

    public static double[][] toDoubleArray(float[][] in) {
        double[][] nw = new double[in.length][in[0].length];
        for (int i = 0; i < nw.length; ++i) {
            for (int j = 0; j < nw[i].length; ++j) {
                nw[i][j] = (double) in[i][j];
            }
        }
        return nw;
    }

    public static double[][] toDoubleArray(int[][] in) {
        double[][] nw = new double[in.length][in[0].length];
        for (int i = 0; i < nw.length; ++i) {
            for (int j = 0; j < nw[i].length; ++j) {
                nw[i][j] = (double) in[i][j];
            }
        }
        return nw;
    }

    public static double[][] toDoubleArray(long[][] in) {
        double[][] nw = new double[in.length][in[0].length];
        for (int i = 0; i < nw.length; ++i) {
            for (int j = 0; j < nw[i].length; ++j) {
                nw[i][j] = (double) in[i][j];
            }
        }
        return nw;
    }

    public static float[][] toFloatArray(int[][] in) {
        float[][] nw = new float[in.length][in[0].length];
        for (int i = 0; i < nw.length; ++i) {
            for (int j = 0; j < nw[i].length; ++j) {
                nw[i][j] = (float) in[i][j];
            }
        }
        return nw;
    }

    public static float[][] toFloatArray(long[][] in) {
        float[][] nw = new float[in.length][in[0].length];
        for (int i = 0; i < nw.length; ++i) {
            for (int j = 0; j < nw[i].length; ++j) {
                nw[i][j] = (float) in[i][j];
            }
        }
        return nw;
    }

    public static float[][] toFloatArray(double[][] in) {
        float[][] nw = new float[in.length][in[0].length];
        for (int i = 0; i < nw.length; ++i) {
            for (int j = 0; j < nw[i].length; ++j) {
                nw[i][j] = (float) in[i][j];
            }
        }
        return nw;
    }

    public static int[][] toIntArray(float[][] in) {
        int[][] nw = new int[in.length][in[0].length];
        for (int i = 0; i < nw.length; ++i) {
            for (int j = 0; j < nw[i].length; ++j) {
                nw[i][j] = (int) in[i][j];
            }
        }
        return nw;
    }

    public static int[][] toIntArray(double[][] in) {
        int[][] nw = new int[in.length][in[0].length];
        for (int i = 0; i < nw.length; ++i) {
            for (int j = 0; j < nw[i].length; ++j) {
                nw[i][j] = (int) in[i][j];
            }
        }
        return nw;
    }

    public static int[][] toIntArray(long[][] in) {
        int[][] nw = new int[in.length][in[0].length];
        for (int i = 0; i < nw.length; ++i) {
            for (int j = 0; j < nw[i].length; ++j) {
                nw[i][j] = (int) in[i][j];
            }
        }
        return nw;
    }

    public static long[][] toLongArray(float[][] in) {
        long[][] nw = new long[in.length][in[0].length];
        for (int i = 0; i < nw.length; ++i) {
            for (int j = 0; j < nw[i].length; ++j) {
                nw[i][j] = (long) in[i][j];
            }
        }
        return nw;
    }

    public static long[][] toLongArray(int[][] in) {
        long[][] nw = new long[in.length][in[0].length];
        for (int i = 0; i < nw.length; ++i) {
            for (int j = 0; j < nw[i].length; ++j) {
                nw[i][j] = (long) in[i][j];
            }
        }
        return nw;
    }

    public static long[][] toLongArray(double[][] in) {
        long[][] nw = new long[in.length][in[0].length];
        for (int i = 0; i < nw.length; ++i) {
            for (int j = 0; j < nw[i].length; ++j) {
                nw[i][j] = (long) in[i][j];
            }
        }
        return nw;
    }
}
