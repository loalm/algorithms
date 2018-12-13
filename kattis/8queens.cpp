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

int main(){
    vector<vector<int> > b(8, vector<int>(8));

    int numQueens = 0;

    for(int i=0;i<8;i++){
        for(int j=0;j<=8;j++){
            char c = getchar();
            if(c == '.') {
                b[i][j] = 0;
            } else if(c == '*'){
                b[i][j] = 1;
                numQueens++;
            }
        }
    }

    if(numQueens != 8) {
        cout << "invalid";
        return 0;
    }

    /*
    for(int i=0;i<8;i++){
        for(int j=0;j<8;j++){
            cout << b[i][j] << " ";
        }
        cout << "\n";
    }*/

    for(int i=0;i<8;i++){
        int rowQueenCount = 0;
        int colQueenCount = 0;
        for(int j=0;j<8;j++){
            if(b[i][j] == 1)
                rowQueenCount++;
            if(b[j][i] == 1)
                colQueenCount++;
        }
        if(rowQueenCount > 1 || colQueenCount > 1){
            cout << "invalid";
            return 0;
        }
    }

    for(int d=0;d<8;d++){
        int dQueenCount = 0;
        int i = d;
        int j = 0;
        while(0 <= i && i < 8 && j < 8){
            if(b[i][j] == 1) dQueenCount++;
            i--;
            j++;
        }
        if(dQueenCount > 1) {
            cout << "invalid";
            return 0;
        }
    }

    for(int d=0;d<8;d++){
        int i = 8-1;
        int j = d;
        int dQueenCount = 0;
        while(j < 8 ) {
            if(b[i][j] == 1) dQueenCount++;
            i--;
            j++;
        }
        if(dQueenCount > 1) {
            cout << "invalid";
            return 0;
        }
    }
    for(int d=0;d<8;d++){
        int dQueenCount = 0;
        int i = d;
        int j = 8-1;
        while(i >= 0 && j >= 0){
            //cout << "test: " << b[i][j];
            if(b[i][j] == 1) dQueenCount++;
            i--;
            j--;
        }
        if(dQueenCount > 1) {
            cout << "invalid";
            return 0;
        }
    }

    for(int d=0;d<8;d++){
        int i = 8-1;
        int j = d;
        int dQueenCount = 0;
        while(j >= 0 && i >= 0) {
            if(b[i][j] == 1) dQueenCount++;
            i--;
            j--;
        }
        if(dQueenCount > 1) {
            cout << "invalid";
            return 0;
        }
    }

    cout << "valid";
}
