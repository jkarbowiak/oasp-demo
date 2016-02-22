package org.zosia.oasp.service;


import org.zosia.oasp.to.PieceTo;
import org.zosia.oasp.to.SetTo;

import java.util.Collection;

public interface PieceService {
    Collection<PieceTo> findOwnedPieces();
}
