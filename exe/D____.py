
def find_candidates(s, t, m):
	k = 0
	still_looking = True
	while still_looking:
		k = s.find(t, k)
		if k > -1:
			yield s[:k]+s[k+m:] 
			k = k+1
		else:
			still_looking = False

def answer(chunk, word):
	r = chunk
	m = len(word)
	candidates = list()
	candidates.append(chunk)
	passed_over = set()

	while len(candidates):
		v = candidates.pop()
		for c in find_candidates(v, word, m):
			if c not in passed_over:
				if len(c) == len(r):
					r = min(c, r)
				elif len(c) < len(r):
					r = c
				passed_over.add(c)
				candidates.append(c)
	return r

def defiddle(s, t):
	i=0
	n=len(s)
	v = s
	while True and t in v:
		if (i+1<n):
			v = s[:i+1] + s[i+1:]
		else:
			break
	
		while t in v:
			v = v.replace(t, '')
		
		yield v
			

##def answer(chunk, word):
#	m = len(word)
#	n = len(chunk)
#	candidates = list()
#	candidates.append('')
#	shortest_len = 1000
#	seen = set() 
#	
#	for i in defiddle(chunk, word):
#		#print '|'+i+'|'
#		length_i = len(i)
#		if length_i < shortest_len:
#			shortest_len = len(i)
#			candidates.pop(0)
#			candidates.insert(0, i)
#		else:
#			if length_i == shortest_len and i not in candidates:
#				candidates.append(i)
#
#	candidates.sort()
#	return candidates[0]

#c = 'aaaaaaabbbbbbb'
#c = 'ababb'
#w ='b'
#c = 'aabb'
#w = 'ab'
#c = 'lololololo'
#w = 'lol'
#c = 'ab____ab____ab'
#w = 'ab'
#c = 'lolol'
#w = 'lol'
#c = 'abc'
#w = 'abc'
	
c = 'lololololo'
w = 'lol'

#c = 'goodgooogoogfogoood'
#w = 'goo'
#w = 'goo'
#
#c = 'aabb'
#w = 'ab'

#c = 'odogdogodgo'
#w = 'god'
print('|'+answer(c, w)+'|')
#print answer(c, w)