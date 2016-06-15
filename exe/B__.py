from array import array

def answer(intervals):
	s = set()
	for i, j in intervals:
		s.add(i)
		s.add(j)
	m = max(s)
	
	times = array('b')
	
	print(m)
	for i in range(m):
		times.append(0)
		
	print(times)
	for i,j in intervals:
		k = i
		print(times)
		while k < j:
			times[k] = 1
			k = k+1
	print(times)
	return sum(times)
		
t = [[1, 3], [3, 6]]
t = [[10, 14], [4, 18], [19, 20], [19, 20], [13, 20]]
a = answer(t)

print(a)