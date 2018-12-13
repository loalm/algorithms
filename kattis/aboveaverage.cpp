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

#define rep(i, a, b) for(int i = (a); i < int(b); ++i)
#define trav(it, v) for(typeof((v).begin()) it = (v).begin(); it != (v).end(); ++it)

typedef vector<int> vi;
typedef vector<vi> vii;
typedef pair<int, int> pii;
typedef long long ll;

double n, w, h;
int mod = 1e9+7;
vi save;


int main(){
    cin >> n;

    while(n-->0) {
        cin >> w;
        double sum = 0;
        double above = 0;
        save.assign(w, -1);

        for(int i = 0; i < w; i++) {
            cin >> save[i];
            sum += save[i];
        }
        sum /= w;
        for(int i = 0; i < w; i++) {
            if(save[i] > sum) {
                above++;
            }
        }
        cout << fixed;
        cout.precision(3);
        cout << (above/w)*100 << "% \n";

    }

}
