

def is_unique_chars(s):
	d = {}
	for i in s:
		if i in d.keys():
			return False
		else:
			d[i] = 0
	
	return True

s = input("write a string:")
print("Does this string have unique chars?\n"+s)
print(is_unique_chars(s))