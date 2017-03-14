
/*
input: array containing N float numbers
output: array size N
int W: size of the window

Example:
input = [3 4 12 4 6 7]
W = 3
output = [avg(three number),avg(next three number), avg(....)   , avg(12, 4, 6), avg(4, 6, 7) = (4+6+7)/3, avg(6, 7)=(6+7)/2, avg(7)= 7/1 ]
*/

public class de_thi_cri_teo {
    public float[] calculateAvg(float[] input, int n, int w) throws Exception {
        if (w == 0 || n <=0) {
            throw new Exception();
        }

        float[] output = new float[n];
        float window = 0;
        for (int i = 0; i < n - w + 1; i++) {
            if (i == 0) {
                for (int j = i; j < i + w; j++) {
                    window = window + input[j];
                }
            } else {
                window = window - input[i-1];
                window = window + input[i+w-1];
            }

            output[i] = window / w;
        }

        int d = w-1 ;
        for (int i = n-w + 1; i<n;i++) {
            window = window - input[i-1];
            output[i] = window / d;
            d--;
        }
        return output;
    }
}