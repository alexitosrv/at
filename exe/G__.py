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

			
def binary_search(low, high, s, parity_correction):
	while low <= high:
		n = low + (high - low)//2
		
		n = n-1 if n%2 == parity_correction else n
		print 'low, n, high', low, n, high
	
		r = R(n)
		
		if r == s:
			return n
		else:
			if r < s:
				low = n+2
			else:
				high = n-2
		
	return -1
	
def answer(str_S):
		
	s = long(str_S)
	n = 0

	# create a range to look for the answer knowing that if s have k-digits, then n will have at most k-digits

	#b = binary_search(0, 10**(2+len(str_S)), s, 1)
	b = binary_search(0, 10**25, s, 1)
	if b == -1:
		b = binary_search(1, 10**25-1, s, 0)
		if b != -1:
			return str(b)
	else:
		return str(b)

	return None
	

	
#print search(0, 6, 6, 1) or search(0, 6, 6, 0)	
#print answer('992')
#print answer('2915')
#print answer('3418')
print answer('13')
#print answer('7')
#print answer('100')
#print answer('532')
#print answer('186832')
#print answer('186835')
#print answer('217026840050179138061511386')
#print answer('217026840050179138061511387')
#for n in range(1,10 ** 3,1):
#	print n, R(n)
#print 10 ** 25, R(10 ** 25)
