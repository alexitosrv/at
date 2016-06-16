
def calculate_new_non_overlapping_intervals(x, y):
	a = x[0]
	b = x[1]
	
	c = y[0]
	d = y[1]
	
	if (a > c):
		if (a < d):
			a_ = c
			b_ = a
			c_ = a
			if (b > d):
				d_ = b
			else:
				d_ = d
			return [[a_, b_], [c_, d_]]
	
	if (b > c):
		if (a < c):
			a_ = a
			b_ = c
			c_ = c
			if (b > d):
				d_ = b
			else:
				d_ = d
			return [[a_, b_], [c_, d_]]
		else:
			a_ = c
			b_ = a
			c_ = a
			if (b > d):
				d_ = b
			else:
				d_ = d
			return [[a_, b_], [c_, d_]]
	
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
		return [[a_, b_], [c_, d_]]
	
		
	if (c > a):
		a_ = a
		b_ = c
		c_ = c 
		if (b > d):
			d_ = b
		else:
			d_ = d
		return [[a_, b_], [c_, d_]]
			
	if (d > a):
		if (c > a):
			a_ = a
			b_ = c
			c_ = c
			if (b > d):
				d_ = b
			else:
				d_ = d
			return [[a_, b_], [c_, d_]]
		else:
			a_ = c
			b_ = a
			c_ = a
			if (b > d):
				d_ = b
			else:
				d_ = d			
			return [[a_, b_], [c_, d_]]
			
	if (d > b):
		if (a < c):
			a_ = a
			b_ = c
			c_ = c
			d_ = d
			return [[a_, b_], [c_, d_]]
		
	if (a == c):
		a_ = a
		if (b > d):
			b_ = d
			c_ = d
			d_ = b
			return [[a_, b_], [c_, d_]]
		else:
			b_ = b
			c_ = b
			d_ = d
			return [[a_, b_], [c_, d_]]
	
	if (b == d):
		if (a < c):
			a_ = a
			b_ = c
			c_ = c
			d_ = d
			return [[a_, b_], [c_, d_]]
		else:
			a_ = c
			b_ = a
			c_ = a
			d_ = d
			return [[a_, b_], [c_, d_]]
	
	return [[a, b], [c, d]]

def overlap(x, y):
	a = x[0]
	b = x[1]
	
	c = y[0]
	d = y[1]
	
	if (a >= d or b <= c): 
		return False
		
	return True



def answer(intervals):

	n = len(intervals)
	intervals.sort()

	s = dict()
	
	n = len(intervals)
	
	for i in range(n):
		s[i] = intervals[i]
		
		for j in range(i+1,n):

			if(overlap(s[i], intervals[j])):
				v,w = calculate_new_non_overlapping_intervals(s[i], intervals[j])
				s[i] = v
				s[j] = w
			else:
				s[j] = intervals[j]

		
	t_intervals = 0

	for i,j in s.values():
		t_intervals = t_intervals + (j-i)
	
	return t_intervals
		
t = [[1, 3], [3, 6]]
#t = [[10, 14], [4, 18], [19, 20], [19, 20], [13, 20]]	
#t = [ [1,3], [2,7], [9,10] ]
#t = [ [1,3], [4,5] ]
#t = [ [1,3] ]
## 2 + 4 + 1 = 7
#print(overlap(t[0],t[1]))
#print(calculate_new_non_overlapping_intervals(t[0],t[1]))
#print(overlap(t[0],t[2]))
#print(t[0],t[2])
print(answer(t))
