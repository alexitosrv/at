import time


def defiddle(s, t):
	
	n = len(s)
	m = len(t)
	k = s.find(t)
	i = 0

	while m>0:
		#print'm',m
		if s[k:k+m] != t:
			#print'k',k, 'k+m', k+m
			#print't in s[k+m:]', t, s[k+m:]
			if (k<m and t in s[k+m:]):
				yield s[k:k+m]+s[k+m:].replace(t, '')
		else:
			yield s.replace(t, '')
			
		m=m-1

def ppp(s):
	for i in s:
		print i

def answer(chunk, word):
	m = len(word)
	n = len(chunk)
	candidates = list()
	candidates.append('')
	shortest_len = 21
	
	#while True:
	for i in defiddle(chunk, word):
		length_i = len(i)
		if length_i < shortest_len:
			shortest_len = len(i)
			candidates.pop(0)
			candidates.insert(0, i)
		else:
			if length_i == shortest_len and i not in candidates:
				candidates.append(i)
			
		#ppp(candidates)
		#time.sleep(5)

	candidates.sort()
	return candidates[0]


c = 'lolol'
w = 'lol'
#c = 'abc'
#w = 'abc'
	
#c = 'lololololo'
#w = 'lol'

c = 'goodgooogoogfogoood'
w = 'goo'
#
#c = 'aabb'
#w = 'ab'
print('|'+answer(c, w)+'|')
#print(answer(c, w))