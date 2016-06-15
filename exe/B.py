
def reduce_when_disjoint(x, y):
	a = x[0]
	b = x[1]
	
	c = y[0]
	d = y[1]
	
	#1,3
	#    6,8
		 
	#1,3+8-6
	return [a,b+d-c]

#def calculate_new_non_overlapping_intervals(x, y):
def reduce(x, y):
	a = x[0]
	b = x[1]
	
	c = y[0]
	d = y[1]
	
	if (a == c and b == d):
		return [0, 0]
		
	if (c == 0 and d == 0):
		return [a, b]

	if (a == 0 and b == 0):
		return [c, d]
	
	if (a > c):
		if (a < d):
			a_ = c
			b_ = a
			c_ = a
			if (b > d):
				d_ = b
			else:
				d_ = d
			return [a_, d_]
	
	if (b > c):
		if (a < c):
			a_ = a
			b_ = c
			c_ = c
			if (b > d):
				d_ = b
			else:
				d_ = d
			return [a_, d_]
		else:
			a_ = c
			b_ = a
			c_ = a
			if (b > d):
				d_ = b
			else:
				d_ = d
			return [a_, d_]
	
	if (b > d):
		if (a < c):
			a_ = a
		else:
			a_ = c
		b_ = c
		c_ = c 
		if (b > d):
			d_ = b
		else:
			d_ = d
		return [a_, d_]
	
		
	if (c > a):
		a_ = a
		b_ = c
		c_ = c 
		if (b > d):
			d_ = b
		else:
			d_ = d
		return [a_, d_]
			
	if (d > a):
		if (c > a):
			a_ = a
			b_ = c
			c_ = c
			if (b > d):
				d_ = b
			else:
				d_ = d
			return [a_, d_]
		else:
			a_ = c
			b_ = a
			c_ = a
			if (b > d):
				d_ = b
			else:
				d_ = d			
			return [a_, d_]
			
	if (d > b):
		if (a < c):
			a_ = a
			b_ = c
			c_ = c
			d_ = d
			return [a_, d_]
		
	if (a == c):
		a_ = a
		if (b > d):
			b_ = d
			c_ = d
			d_ = b
			return [a_, d_]
		else:
			b_ = b
			c_ = b
			d_ = d
			return [a_, d_]
	
	if (b == d):
		if (a < c):
			a_ = a
			b_ = c
			c_ = c
			d_ = d
			return [a_, d_]
		else:
			a_ = c
			b_ = a
			c_ = a
			d_ = d
			return [a_, d_]
	
	return [a, d]

def overlap(x, y):
	a = x[0]
	b = x[1]
	
	c = y[0]
	d = y[1]
	
	if (a > d or b < c): 
		return False
		
	return True



def answer(intervals):
	interv = list()
	for i in intervals:
		if i not in interv:
			interv.append(i)

	n = len(interv)
	
	print()
	print("interv", interv)
	print("n", n)
	
	# transform all t in interv into non overlapping tuples:
	i = 0
	while( n > 1 ):

		t = interv[0]
		u = interv[1]
		
		interv.remove(t)
		interv.remove(u)
		
		if (overlap(t, u)):
			interv.append(reduce(t, u))
		else:
			interv.append(reduce_when_disjoint(t, u))
			
		interv2 = list()
		for k in interv:
			if k not in interv2:
				interv2.append(k)
		interv = interv2
		n = len(interv)
		
		print()
		print("interv", interv)
		print("n", n)

		
	t_intervals = 0

	#for i,j in s.values():
	#	t_intervals = t_intervals + (j-i)
	#
	return t_intervals
		
#t = [[1, 2]]
t = [[1, 3], [3, 6]]
#t = [[1, 3], [6, 8]]
#t = [[10, 14], [4, 18], [19, 20], [19, 20], [13, 20]]	

#print(overlap([1,5],[4,9]))
#print(reduce([1,5],[4,9]))
print(answer(t))
