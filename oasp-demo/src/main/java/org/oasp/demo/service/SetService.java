package org.oasp.demo.service;


import org.oasp.demo.to.*;

import java.util.Collection;

public interface SetService {

    Collection<SetTo> findOwnedSets();

    Collection<SetTo> findWantedSets();

    void addWantedSet(WantedSetTo setTo);
}
