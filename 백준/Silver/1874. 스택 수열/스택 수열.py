from collections import deque

stack = deque()

a = int(input())
b = []
c = []
d = []
count = 0
count_stack = 0

while count < a:
    b.append(int(input()))
    count += 1

for i in range(1, a + 1):
    stack.appendleft(i)
    d.append('+')

    while stack and b[count_stack] == stack[0]:
        c += [stack.popleft()]
        d.append('-')
        count_stack += 1

if b == c:
    for i in d:
        print(i)
else:
    print('NO')