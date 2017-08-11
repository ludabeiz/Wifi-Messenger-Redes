package it.polimi.deib.p2pchat.discovery.chatmessages.waitingtosend;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

class WaitingToSendListElement {

    @Getter private final List<String> waitingToSendList;

    /**
     * Constructor of the class.
     */
    public WaitingToSendListElement () {
        waitingToSendList = new ArrayList<>();
    }
}
