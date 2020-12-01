package bean.messageBean;

import bean.Rank;

import java.util.List;

public class RankMessage extends Message{
    private List<Rank> ranks;

    public List<Rank> getRanks() {
        return ranks;
    }

    public void setRanks(List<Rank> ranks) {
        this.ranks = ranks;
    }
}
