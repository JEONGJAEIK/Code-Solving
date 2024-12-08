import sys

a, b = map(int, sys.stdin.readline().rstrip().split())
c = [[0 for i in range(b)] for j in range(a)]
d = []

for i in range(a):
    c[i]= sys.stdin.readline().rstrip()


arr1 = [[0 for i in range(8)] for j in range(8)]
arr2 = [[0 for i in range(8)] for j in range(8)]

for i in range(8):
    for j in range(8):
        if (i + j) % 2 == 0:
            arr1[i][j] = 'B'
        else:
            arr1[j][i] = 'W'

for i in range(8):
    for j in range(8):
        if (i + j) % 2 == 0:
            arr2[i][j] = 'W'
        else:
            arr2[j][i] = 'B'



def test(x, w):
    count1 = 0
    count2 = 0
    for k in range(8):
        w = u
        for y in range(8):
            if arr1[k][y] != c[x][w]:
                count1 += 1
            if arr2[k][y] != c[x][w]:
                count2 += 1
            w += 1
        x += 1

    if count1 > count2:
        return count2
    else:
        return count1


for q in range(a - 7):
    for u in range(b - 7):
        d += list(map(int, str(test(q, u)).split()))


print(min(d))


# c = [""] * a
#
# for i in range(a):
#     c[i] += sys.stdin.readline().rstrip()
#
# for j in range(a):