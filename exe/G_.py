

def answer(str_S):
	m = {}
	m[0] = 1
	m[1] = 1
	m[2] = 2

	def R(n):
		if n in m:
			return m[n]
			
		n_ = n // 2
		
		if n % 2 == 0:
			m[n] = R(n_+1) + R(n_) + n_
		else:	
			m[n] = R(n_-1) + R(n_) + 1

		return m[n]
			
	def binary_search_leaping_twice(low, high, s, parity_correction):
		while low <= high:
			n = low + (high - low)//2
			
			n = n-1 if n%2 == parity_correction else n
			#print 'low, n, high', low, n, high

			r = R(n)
			
			if r == s:
				return n
			else:
				if r < s:
					low = n+2
				else:
					high = n-2
			
		return -1
		
	s = long(str_S)
	n = 0

	# create a range to look for the answer knowing that if s have k-digits, then n will have at most k-digits

	b = binary_search_leaping_twice(0, 10 ** len(str_S), s, 1)
	if b == -1:
		b = binary_search_leaping_twice(1, (10 ** len(str_S))-1, s, 0)
		if b != -1:
			return str(b)
	else:
		return str(b)

	return 'None'
	

	
	
print answer('6')
print answer('7')
print answer('100')
print answer('217026840050179138061511386')
print answer('217026840050179138061511387')
#for n in range(1,10 ** 2,2):
#print n, R(n)
#print 10 ** 25, R(10 ** 25)
