package com.example.lk.ijse.gdse63.travelcw.service.impl;


import com.example.lk.ijse.gdse63.travelcw.dto.GuideDTO;
import com.example.lk.ijse.gdse63.travelcw.entity.Guide;
import com.example.lk.ijse.gdse63.travelcw.exception.*;
import com.example.lk.ijse.gdse63.travelcw.repo.GuideRepo;
import com.example.lk.ijse.gdse63.travelcw.service.GuidService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class GuideServiceIMPL implements GuidService {
    ModelMapper mapper;
    Gson gson;
    GuideRepo repo;
    public GuideServiceIMPL(ModelMapper mapper, Gson gson, GuideRepo repo) {
        this.mapper = mapper;
        this.gson = gson;
        this.repo = repo;
    }

    @Override
    public int saveGuide(GuideDTO guideDTO) throws SaveFailException {
        try {
            Guide map = mapper.map(guideDTO, Guide.class);
            map.setBirthDate(Date.valueOf(guideDTO.getBirthDate()));
            exportImages(guideDTO, map);
            return repo.save(map).getId();
        }catch (Exception e){
            throw new SaveFailException("Operation Fail", e);
        }
    }

    @Override
    public void updateGuide(GuideDTO guideDTO) throws UpdateFailException {
        try {
            Optional<Guide> byId = repo.findById(guideDTO.getId());
            if (byId.isPresent()){
                deleteImages(byId.get());
                Guide map = mapper.map(guideDTO, Guide.class);
                map.setBirthDate(Date.valueOf(guideDTO.getBirthDate()));
                exportImages(guideDTO, map);
                repo.save(map);
            }else {
                throw new NotFoundException("Not Found");
            }

        }catch (Exception e){
            throw new UpdateFailException("Operation Fail", e);
        }
    }

    @Override
    public void deleteGuide(int id) throws DeleteFailException {
        try {
            repo.findById(id).ifPresent(this::deleteImages);
            repo.deleteById(id);

        }catch (Exception e){
            throw new DeleteFailException("Operation Fail", e);
        }

    }

    @Override
    public GuideDTO getGuide(int id) throws SearchFailException {
        try {
            Optional<Guide> byId = repo.findById(id);
            if (byId.isPresent()){
                GuideDTO guide = mapper.map(byId.get(), GuideDTO.class);
                guide.setBirthDate(byId.get().getBirthDate().toLocalDate());
                importImages(guide,byId.get());
                return guide;
            }
            throw new NotFoundException("Not Found");
        }catch (Exception e){
            throw new SearchFailException("Operation Fail", e);
        }
    }

    public void exportImages(GuideDTO guideDTO, Guide guide) {
        String dt = LocalDate.now().toString().replace("-", "_") + "__"
                + LocalTime.now().toString().replace(":", "_");
        try {
            InputStream is = new ByteArrayInputStream(guideDTO.getGuideIdFront());
            BufferedImage bi = ImageIO.read(is);
            File outputfile = new File("images/guide/front/" + dt + "_" + ".jpg");
            ImageIO.write(bi, "jpg", outputfile);
            guide.setGuideIdFront(outputfile.getAbsolutePath());

            is = new ByteArrayInputStream(guideDTO.getGuideIdRear());
            bi = ImageIO.read(is);
            outputfile = new File("images/guide/rear/" + dt + "_" + ".jpg");
            ImageIO.write(bi, "jpg", outputfile);
            guide.setGuideIdRear(outputfile.getAbsolutePath());

            is = new ByteArrayInputStream(guideDTO.getNicFront());
            bi = ImageIO.read(is);
            outputfile = new File("images/guide/nic/front/" + dt + "_" + ".jpg");
            ImageIO.write(bi, "jpg", outputfile);
            guide.setNicFront(outputfile.getAbsolutePath());

            is = new ByteArrayInputStream(guideDTO.getNicRear());
            bi = ImageIO.read(is);
            outputfile = new File("images/guide/nic/rear/" + dt + "_" + ".jpg");
            ImageIO.write(bi, "jpg", outputfile);
            guide.setNicRear(outputfile.getAbsolutePath());

            is = new ByteArrayInputStream(guideDTO.getProfilePic());
            bi = ImageIO.read(is);
            outputfile = new File("images/guide/profile/" + dt + "_" + ".jpg");
            ImageIO.write(bi, "jpg", outputfile);
            guide.setProfilePic(outputfile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importImages(GuideDTO guideDTO, Guide guide) {
        try {
            BufferedImage r = ImageIO.read(new File(guide.getGuideIdFront()));
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ImageIO.write(r, "jpg", b);
            byte[] imgData= b.toByteArray();
            guideDTO.setGuideIdFront(imgData);

            r = ImageIO.read(new File(guide.getGuideIdRear()));
            b = new ByteArrayOutputStream();
            ImageIO.write(r, "jpg", b);
            imgData= b.toByteArray();
            guideDTO.setGuideIdRear(imgData);

            r = ImageIO.read(new File(guide.getNicFront()));
            b = new ByteArrayOutputStream();
            ImageIO.write(r, "jpg", b);
            imgData= b.toByteArray();
            guideDTO.setNicFront(imgData);

            r = ImageIO.read(new File(guide.getNicRear()));
            b = new ByteArrayOutputStream();
            ImageIO.write(r, "jpg", b);
            imgData= b.toByteArray();
            guideDTO.setNicRear(imgData);

            r = ImageIO.read(new File(guide.getProfilePic()));
            b = new ByteArrayOutputStream();
            ImageIO.write(r, "jpg", b);
            imgData= b.toByteArray();
            guideDTO.setProfilePic(imgData);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteImages(Guide guide) {
        File file = new File(guide.getGuideIdFront());
        boolean delete = file.delete();
        System.out.println("Images " + delete);

        file = new File(guide.getGuideIdRear());
        delete = file.delete();
        System.out.println("Images " + delete);

        file = new File(guide.getNicFront());
        delete = file.delete();
        System.out.println("Images " + delete);

        file = new File(guide.getNicRear());
        delete = file.delete();
        System.out.println("Images " + delete);

        file = new File(guide.getProfilePic());
        delete = file.delete();
        System.out.println("Images " + delete);

    }

}
