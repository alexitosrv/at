
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

def answer(intervals):
	interv = list()
	for i in intervals:
		if i not in interv:
			interv.append(i)
	
	interv.sort()
	
	n = len(interv)
	i = 0
	while i < n:
		j = i+1
		while j < n:
			t = interv[i]
			u = interv[j]

			if (overlap(t, u)):
				v = reduce(t, u)
				
				if t in interv:
					interv.remove(t)
					n = n - 1
				if u in interv:
					interv.remove(u)
					n = n - 1
				if v not in interv:
					interv.insert(0,v)
					n = n + 1
			else:
				j = j+1
		i =i +1

	s = 0
	for i in interv:
		s = s + i[1] - i[0]
	return s
		
#t = [[1, 2]]
#t = [[1, 3], [3, 6]]
#t = [[1, 3], [6, 8]]
#t = [[10, 14], [4, 18], [19, 20], [19, 20], [13, 20]]	

#print(overlap([1,200],[4,9]))
#print(reduce([4,18],[10,20]))
print(answer(t))