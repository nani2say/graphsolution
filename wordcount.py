#Program to print the frequency of words in a file (test.txt)

from collections import Counter
import re
words = re.findall(r'\w+', open('test.txt').read().lower())
counter = Counter(words)
#to print in required format
for word, count in counter.items():
    print str(count) +" "+word
