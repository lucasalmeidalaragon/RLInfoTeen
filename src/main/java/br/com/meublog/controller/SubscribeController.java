package br.com.meublog.controller;

import br.com.meublog.model.business.Viewer;
import br.com.meublog.model.dao.ViewerDAO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author fernando
 */
@Named("subscribeBean")
@RequestScoped
public class SubscribeController extends AbstractController {

    @Inject
    private ViewerDAO viewerDAO;

    @Inject
    private Viewer viewer;

    public String saveSubscriber() {
        viewerDAO.save(viewer);
        return "";
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

}
