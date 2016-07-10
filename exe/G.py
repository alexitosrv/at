
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

def R_(n):
	if n == 0:
		return 1
	
	if n == 1:
		return 1
	
	if n == 2:
		return 2
	
	n_ = n // 2
	if n % 2 == 0:
		return R_(n_) + R_(n_+1) + n_

	return R_(n_-1) + R_(n_) + 1

def answer(str_S):
		
	s = long(str_S)
	n = 0
	r = 0

	### create a range and look for the answer knowing that if s have k digits, then n will have at most k digits
	
	n_low_even = 0
	n_high_even = 10 ** len(str_S)
	while n_low_even <= n_high_even:
		n_even = n_low_even + (n_high_even - n_low_even)//2
		
		if n_even % 2 == 1:
			n_even = n_even - 1
		#print 'n_low_even, n_even, n_high_even', n_even, n_low_even, n_high_even

		r_even = R(n_even)
		
		if r_even == s:
			return str(n_even)
		else:
			if r_even < s:
				n_low_even = n_even + 2
			else:
			#r_even > s:
				n_high_even = n_even - 2
		

	n_low_odd = 1
	n_high_odd = (10 ** len(str_S)) - 1
	while n_low_odd <= n_high_odd:
		n_odd = n_low_odd + (n_high_odd - n_low_odd)//2
		
		if n_odd % 2 == 0:
			n_odd = n_odd - 1			
		
		r_odd = R(n_odd)
		
		if r_odd == s:
			return str(n_odd)
		else:
			if r_odd < s:
				n_low_odd = n_odd + 2
			else:
			#if r_odd > s:
				n_high_odd = n_odd - 2

	return 'None'
	

	
	
print answer('6')
print answer('7')
print answer('100')
print answer('217026840050179138061511387') # 10 ** 25
print answer('217026840050179138061511386')
#for n in range(1,10 ** 2,2):
#print n, R(n)
#print 10 ** 25, R(10 ** 25)
