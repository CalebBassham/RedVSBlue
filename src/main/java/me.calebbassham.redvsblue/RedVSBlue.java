package me.calebbassham.redvsblue;

import me.calebbassham.scenariomanager.api.SimpleScenario;
import me.calebbassham.scenariomanager.api.TeamAssigner;
import me.calebbassham.scenariomanager.api.uhc.TeamProvider;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.concurrent.CompletableFuture;

public class RedVSBlue extends SimpleScenario implements TeamAssigner {

    @Override
    public CompletableFuture<Void> onAssignTeams(TeamProvider teams, Player[] players) {
        Team red = teams.mustRegisterTeam("red", ChatColor.RED);
        Team blue = teams.mustRegisterTeam("blue", ChatColor.BLUE);

        for (int i = 0; i < players.length; i++) {
            Player player = players[i];

            if (i % 2 == 0) {
                red.addEntry(player.getName());
            } else {
                blue.addEntry(player.getName());
            }
        }

        broadcast("Assigned players to teams.");

        return CompletableFuture.completedFuture(null);
    }

}
