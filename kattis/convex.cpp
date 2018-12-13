#include <cstdio>
#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>
#include <set>
#include <map>
#include <queue>
#include <stack>

using namespace std;
int n, m, h;
int mod = 1e9+7;


double calc(int x1, int y1, int x2, int y2, int x3, int y3) {

    double b = sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    double c = sqrt((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));

    double v = asin(abs(x2-x1)/b)+asin(abs(x3-x2)/c);
    //cout << v << "\n";
    return b*c*sin(v)/2;
}

int main(){
    cin >> n;

    while(n-->0) {
        cin >> m;
        int arr[m*2];
        for(int i = 0; i < (m*2); i++) {
            cin >> arr[i];
            arr[i] += 70000;
        }
        double res = 0;
        int x1 = arr[0];
        int y1 = arr[1];
        for(int i = 2; i < m*2-3; i+=2) {
            int x2 = arr[i];
            int y2 = arr[i+1];
            int x3 = arr[i+2];
            int y3 = arr[i+3];
            res += calc(x1,y1,x2,y2,x3,y3);
        }
        cout << res << "\n";
    }

}
