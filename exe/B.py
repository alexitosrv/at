
def reduce(x, y):
	a = x[0]
	b = x[1]
	
	c = y[0]
	d = y[1]

	return [min(a, b, c, d), max(a,b,c,d)]

def overlap(x, y):
	a = min(x[0], x[1])
	b = max(x[0], x[1])
	
	c = min(y[0], y[1])
	d = max(y[0], y[1])
	
	return c < b

def overlapable(intervs):
	for i in range(len(intervs)):
		for j in range(i+1,len(intervs)):
			if overlap(intervs[i], intervs[j]):
				return True
				
	return False
			

def answer(intervals):
	interv = list()
	for i in intervals:
		if i not in interv:
			interv.append(i)

	
	while (overlapable(interv)):
		r = list()
		n = len(interv)
		#print("interv y n= ", interv, n)
		for i in range(n):
			t = interv[i]
			for j in range(i+1,n):
				u = interv[j]
				if (overlap(t, u)):
					v = reduce(t, u)
					if v not in r:
						r.append(v)
				else:
					if u not in r:
						r.append(u)

		s = list()
		for i in r:
			if i not in s:
				s.append(i)
				
		r = s
		interv = r
		
	#print(interv)
	s = 0
	for i in interv:
		s = s + i[1] - i[0]
	return s
		
#t = [[1, 2]]
t = [[1, 3], [3, 6]]
#t = [[1, 3], [6, 8]]
#t = [[10, 14], [4, 18], [19, 20], [19, 20], [13, 20]]	

#print(overlap([1,200],[4,9]))
#print(reduce([4,18],[10,20]))
#
#  4
#  -
#1   5
#  4      9
#      -
#	  8
#print(answer(t))