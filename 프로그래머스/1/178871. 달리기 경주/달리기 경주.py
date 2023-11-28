def solution(players, callings):
    rank = dict()
    
    for idx, player in enumerate(players):
        rank[player] = idx
    
    for player in callings:
        idx = rank[player]
        players[idx], players[idx - 1] = players[idx - 1], players[idx]
        rank[players[idx]] = idx
        rank[players[idx - 1]] = idx - 1
        
    return players