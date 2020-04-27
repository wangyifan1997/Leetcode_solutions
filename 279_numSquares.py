class Solution_v1:
    # 3804 ms
    def numSquares(self, n: int) -> int:
        squares = [i ** 2 for i in range(1, int(n ** 0.5 + 1))]
        if n == 1:
            return 1
        if n == 2:
            return 2
        if n == 3:
            return 3
        if n == 4:
            return 1
        arr = [0] * (n + 1)
        arr[1] = 1
        arr[2] = 2
        arr[3] = 3
        arr[4] = 1
        for i in range(5, n + 1):
            temp = []
            for square in squares:
                if square < i:
                    temp.append(arr[square] + arr[i - square])
                elif square == i:
                    temp.append(1)
            arr[i] = min(temp)
        return arr[n]

class Solution_v2:
    #2852 ms
    def numSquares(self, n: int) -> int:
        squares = [i ** 2 for i in range(1, int(n ** 0.5 + 1))]
        if n == 1:
            return 1
        if n == 2:
            return 2
        if n == 3:
            return 3
        if n == 4:
            return 1
        arr = [0] * (n + 1)
        arr[1] = 1
        arr[2] = 2
        arr[3] = 3
        arr[4] = 1
        for i in range(5, n + 1):
            temp = float("inf")
            for square in squares:
                if square < i:
                    val = arr[square] + arr[i - square]
                    if val < temp:
                        temp = val
                elif square == i:
                    temp = 1
            arr[i] = temp
        return arr[n]

class Solution_v3:
    # 2760 ms
    def numSquares(self, n: int) -> int:
        squares = [i ** 2 for i in range(1, int(n ** 0.5 + 1))]
        if n == 1:
            return 1
        if n == 2:
            return 2
        if n == 3:
            return 3
        if n == 4:
            return 1
        arr = [0] * (n + 1)
        arr[1] = 1
        arr[2] = 2
        arr[3] = 3
        arr[4] = 1
        for i in range(5, n + 1):
            if (i ** 0.5) % 1 == 0 :
                arr[i] = 1
            else:
                temp = float("inf")
                for square in squares:
                    if square < i:
                        val = arr[square] + arr[i - square]
                        if val < temp:
                            temp = val
                arr[i] = temp
        return arr[n]