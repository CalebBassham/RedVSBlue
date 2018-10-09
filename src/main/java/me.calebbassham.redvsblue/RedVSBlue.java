package me.calebbassham.redvsblue;

import me.calebbassham.scenariomanager.api.SimpleScenario;
import me.calebbassham.scenariomanager.api.TeamAssigner;
import me.calebbassham.scenariomanager.api.uhc.TeamProvider;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class RedVSBlue extends SimpleScenario implements TeamAssigner {

    @NotNull
    @Override
    public CompletableFuture<Void> onAssignTeams(@NotNull TeamProvider teams, @NotNull Player[] players) {
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
