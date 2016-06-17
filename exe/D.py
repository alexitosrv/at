import time


def defiddle(s, t):

	#return s.replace(t, '')
	
	n = len(s)
	m = len(t)
	k = s.find(t)
	i = 0
	
	#while k+i<m and k+i<n:
	while m>=0:
		print'm',m
		if s[k:k+m] != t:
			print'k',k, 'k+m', k+m
			#yield s[k:k+(m-i+1)]+'|'+s[k+(m-i)+1:].replace(t, '')
			print't in s[k+m:]', t, s[k+m:]
			if (k<m and t in s[k+m:]):
				yield s[k:k+m]+'|'+s[k+m:].replace(t, '')
		else:
			yield s.replace(t, '')
			
		m=m-1

def ppp(s):
	for i in s:
		print i

def answer(chunk, word):
	m = len(word)
	n = len(chunk)
	
	#while True:
	for i in defiddle(chunk, word):
		print i
		time.sleep(5)


#c = 'lolol'
#w = 'lol'
	
#c = 'lololololo'
#w = 'lol'
#
c = 'goodgooogoogfogoood'
w = 'goo'
#
#c = 'aabb'
#w = 'ab'
answer(c, w)
#print(answer(c, w))