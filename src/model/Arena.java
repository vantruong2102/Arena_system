package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp gốc (Root Object) đại diện cho một thể hiện thực thi (Instantiation) của hệ thống ARENA.
 */
public class Arena {
    private int maxTournaments;
    private double flatFeeForSponsorship;
    private List<Advertiser> advertisers;
    private List<InterestGroup> interestGroups;

    public Arena(int maxTournaments, double flatFeeForSponsorship) {
        this.maxTournaments = maxTournaments;
        this.flatFeeForSponsorship = flatFeeForSponsorship;
        this.advertisers = new ArrayList<>();
        this.interestGroups = new ArrayList<>();
    }

    public double getFlatFeeForSponsorship() {
        return flatFeeForSponsorship;
    }

    public List<Advertiser> getAdvertisers() {
        return advertisers;
    }

    public List<InterestGroup> getInterestGroups() {
        return interestGroups;
    }

    public void addAdvertiser(Advertiser advertiser) {
        advertisers.add(advertiser);
    }

    public void addInterestGroup(InterestGroup group) {
        interestGroups.add(group);
    }
}
