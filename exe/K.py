from math import ceil



def answer(pegs):
	n = len(pegs)
	g = range(n)
	k = pegs[1] - pegs[0]
	print 'k=',k
	print 'k-1=',k-1
	print 'k-2=',k-2	
	for i in range(1, k): 
		g[0] = i
		
		# calculate all others in terms of the current value of g[0]

		for j in range(1, n):
			#print pegs[j], pegs[j-1], g[j-1]
			g[j] = (pegs[j] - pegs[j-1]) - g[j-1]  

		print g
		if g[-1]!=0 and g[0]>g[-1] and g[-1]>0 and (1.0*g[0] / g[-1] == 2.0):
			return [g[0],1]
			#print "|",(1.0 * (g[0] / g[-1]))
			#
			#print 'encontrado en:'
			#print g#[0], g[-1]
			#print 
		#exit(0)
	
	return [-1, -1]

p = [4,30,50]
p = [1,20]
#p = [1,6,11]

#1 2 3 4 5 6 7 8 9 A B

print answer(p)

