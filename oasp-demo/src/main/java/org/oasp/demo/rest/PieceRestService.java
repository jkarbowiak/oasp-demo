package org.oasp.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.oasp.demo.service.PieceService;
import org.oasp.demo.to.PieceTo;

import java.util.Collection;

@RequestMapping("/services")
@RestController
public class PieceRestService {

    private final PieceService pieceService;

    @Autowired
    public PieceRestService(PieceService pieceService) {
        this.pieceService = pieceService;
    }

    @RequestMapping(value = "/pieces/owned", method = RequestMethod.GET)
    @ResponseBody
    public Collection<PieceTo> findOwnedPieces() {
        return pieceService.findOwnedPieces();
    }

}
