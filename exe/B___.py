from array import array

def answer(intervals):
	r = 0
	h = dict()
	l = dict()
	
	for k, t in enumerate(intervals):
		h[t[1]] = k
		l[t[0]] = k
	
	for t in intervals:
		r = r + intervals[1]-intervals[0]

	
		
	return r
		
t = [[1, 3], [3, 6]]
t = [[10, 14], [4, 18], [19, 20], [19, 20], [13, 20]]

a = answer(t)

print(a)