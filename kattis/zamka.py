# print out MAX and MIN of number between L and D, when digits of number printed out
# must add up to X. If X = 5. 50 or 41 or 32 may be printed out. 3 + 2 = 5.
L = int(input())
D = int(input())
X = int(input())
first = False
sum=0
max = L
for t in range(L,D+1):

	# find sum of digits in t by looping through lists of digits
	# and adding to sum
	siffer = list(str(t))
	for num in siffer:
		sum+=int(num)
	if(not first and sum == X):
		print("%d " % t)
		first = True # have printed MIN
	if(sum == X):
		 max = t
	sum = 0 # reset for next iteration

print(max)
