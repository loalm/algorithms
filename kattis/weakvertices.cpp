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

int n, w, h;
int mod = 1e9+7;
vii matrix;

ll calc(int pos, int ribbon) {
    //cout << "Pos: " << pos << " " << "Ribbon: " << ribbon << endl;
    if(ribbon > n) return 0;
    if(pos == w) return 1;
    if(matrix[pos][ribbon] != -1) return matrix[pos][ribbon];
    ll ans = 0;
    rep(i, 0, h+1) {
        ans += calc(pos+1, ribbon+i);
    }
    return matrix[pos][ribbon] = ans%mod;
}

int main(){

    cin >> n;

    while(n != -1) {

    matrix.assign(n, vi(n, -1));

    for(int i = 0; i < n; i++) {
        for(int j = 0 ; j < n; j++) {
            cin >> matrix[i][j];
        }
    }
    bool found = false;
    for(int i = 0; i < n; i++) {
        found = false;
        //current node : i
        for(int j = 0 ; j < n; j++) {
            if(matrix[i][j] == 1) {
                //i connected to j.
                for(int k = 0; k < n; k++) {
                    if(matrix[i][k] == 1 && matrix[j][k] == 1) {
                        found = true;
                        break;
                    }
                }
            }

        }
        if(!found) {
            cout << i << " ";
        }
    }
    cout << "\n";
    cin >> n;
}


}
