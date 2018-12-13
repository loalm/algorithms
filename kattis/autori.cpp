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

int main(){

    string n;
    cin >> n;
    for(int i = 0; i < n.length(); i++) {
        //cout << (int)n[i] << "\n";
        if(65 <= (int)n[i] && (int)n[i] <= 65+25)
            cout << n[i];
    }

}
