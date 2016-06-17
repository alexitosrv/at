import time




def ppp(s):
	for i in s:
		print i

def answer(chunk, word):
	s = list()
	s.append(chunk)
	m = len(word)
	n = len(chunk)
	k = 0
	
	while m <= n and k>=0:
		c = s[k]
		n = len(c)
		
		idx = c.find(word)
		
		if idx >= 0:
			#idx point where it was found for the first time
			print 'idx:', idx, 'n:', n, 'm:', m
			for j in range(m):#j: 0 to m, m the length of w 
				print
				print 'j:',j
				if idx + j < n  :
					print 'original:', c
					print 'c:', c[:idx+j]+']['+c[idx+j:]
					print 'suffix string:',c[:idx+j]
					print 'string to replace: ',c[idx+j:]
					d = c[:idx+j]+c[idx+j:].replace(word, '')
					print 'result:', d

					if d != chunk and d not in s:
						s.append(d)
						k = len(s)
						
					if n == m:
						n, m = -1, 0
						break

		print
		print
		print 's:'
		ppp(s)
		time.sleep(30)
		k = k -1
	return s

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