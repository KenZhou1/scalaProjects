def searchWord(filename, word):

    rhyme = []
    word = word.upper()

    with open(filename, "r") as file:
        for line in file.readlines():
            line = line.rstrip("\n\r")
            arr = line.split(" ")
            if arr[0] == word:
                for i in range(2, len(arr), 1):
                    rhyme.append(arr[i])


    file.close()

    return list(reversed(rhyme))

def getSounds(filename, word):

    rhyme = []
    word = word.upper()

    with open(filename, "r") as file:
        for line in file.readlines():
            line = line.rstrip("\n\r")
            arr = line.split(" ")
            if arr[0] == word:
                for i in range(2, len(arr), 1):
                    rhyme.append(arr[i])


    file.close()

    return rhyme


def findRhymes(filename, word):
    empty = []
    found = searchWord(filename,word)
    if len(found) == 0:
        return empty
    word = word.upper()
    
    ans = [] 
    with open(filename, "r") as file:
        for line in file.readlines():
            line = line.rstrip("\n\r")
            arr = line.split(" ")
            rhyming = list(reversed(arr))
            for i in range(0, len(rhyming), 1):
                if len(found) < i:
                    break 
                else: 
                    rhyming2 = rhyming[i].replace("0","")
                    rhyming2 = rhyming2.replace("1","")
                    rhyming2 = rhyming2.replace("2","")

                    rhyming3 = found[i].replace("0","")
                    rhyming3 = rhyming3.replace("1","")
                    rhyming3 = rhyming3.replace("2","")

                    if rhyming2 == rhyming3:
                        if len(rhyming[i]) == 3:

                            ans.append(arr[0])
                            break
                            
                    else:
                        break
    return ans

