package org.oasp.demo.service;


import org.oasp.demo.to.PieceTo;

import java.util.Collection;

public interface PieceService {
    Collection<PieceTo> findOwnedPieces();
}
